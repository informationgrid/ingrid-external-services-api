/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.Location;


/**
 * Interface (API) for accessing gazetteer.<p>
 * The basic semantic unit of the gazetteer is a <code>Location</code> encapsulating location data.
 */
public interface GazetteerService {

	/** Which locations to query from gazetteer (utilized in SNS). */
	public enum QueryType {
		/** all locations, no special type e.g. nations, natural parks, mountains ... */
		ALL_LOCATIONS,
		/** only administrative locations, meaning nations, countries, federal states ... */
		ONLY_ADMINISTRATIVE_LOCATIONS;
	}

    /**
     * Get all related gazetteer-locations of a given gazetteer-location.<br/>
     * <ul><li>used in Portal Extended Search for showing associated locations of a
     * given location, e.g. showing capital city of a country.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text, click "Look-up Geographic Names" and click on found location
     * </ul>
     * @param locationId the unique identifier of a location in the gazetteer
     * @param language request results in this language. If passed language can't be processed
     * 		or is null then default language may be used (PortalU: de, GS Soil: en) 
     * @return Array of related locations found for passed location (or empty array)
     */
    Location[] getRelatedLocationsFromLocation(String locationId, Locale language);

    /**
     * Analyze arbitrary TEXT delivering gazetteer locations.
     * When using SNS the autoClassify method of SNS is used.<br/>
     * <ul><li>used in Portal Extended Search for look up of locations from arbitrary
     * entered text see<br/>
     * PortalU: http://localhost:8080/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text and click "Look-up Geographic Names"
     * </ul>
     * @param text arbitrary text to classify. Multiple words, sentences etc.
     * @param analyzeMaxWords The maximum number of words to analyze
     * @param ignoreCase Set to true to ignore capitalization of the text
     * @param language language of text
     * @return Array of Locations found for text (or empty array).
     */
    Location[] getLocationsFromText(String text, int analyzeMaxWords, boolean ignoreCase, Locale language);

    /**
     * Search for location by an arbitrary query term (single word or words belonging together).
     * This allows search with additional search criteria like typeOfQuery. 
     * This one is separated from <code>getLocationsFromText</code> because a different method
     * is called when using SNS (findTopics). There specific <b>types</b> of locations can be queried !<br/>
     * <ul>
     * <li>used in IGE when location of catalog is chosen. There only administrative locations are queried !
     * <li>when using SNS here's the method used: http://www.semantic-network.de/doc_findtopics.html?lang=en
     * </br> we always search "also in the flexion of names"
     * </ul>
     * @param queryTerm an arbitrary term (single word or words belonging together). 
     * @param typeOfQuery which type of locations to query from gazetteer (utilized in SNS)
     * @param language language of queryTerm
     * @return Array of Locations found for queryTerm (or empty array).
     */
    Location[] findLocationsFromQueryTerm(String queryTerm, QueryType typeOfQuery, Locale language);
}
