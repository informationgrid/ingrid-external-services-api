/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2017 wemove digital solutions GmbH
 * ==================================================
 * Licensed under the EUPL, Version 1.1 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 * 
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl5
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * **************************************************#
 */
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

	/** When searching for location in gazetteer with a given input name.
	 * How should the location match the input ? Only needed when requesting special search (findLocations...)*/
	public enum MatchingType {
		/** the location contains the input */
		CONTAINS,
		/** the location begins with the input */
		BEGINS_WITH,
		/** the location exactly matches the input */
		EXACT;
	}

    /**
     * Search for location by an arbitrary query term (single word or words belonging together).
     * This allows search with additional search criteria like typeOfQuery and matching type. 
     * This one is separated from <code>getLocationsFromText</code> because a different method
     * is called when using SNS (findTopics). Here specific <b>types</b> of locations can be queried !<br/>
     * <ul>
     * <li>used in IGE when location of catalog is chosen. There only administrative locations are queried !
     * <li>when using SNS here's the method used: http://www.semantic-network.de/doc_findtopics.html?lang=en
     * </br> we always search "also in the flexion of names"
     * </ul>
     * @param queryTerm an arbitrary term (single word or words belonging together). 
     * @param typeOfQuery which type of locations to query from gazetteer (utilized in SNS)
     * @param matching occurence of the query term during search. Supports exact match, beginning of word, and contained.
     * @param language language of queryTerm and results
     * @return Array of Locations found for queryTerm (or empty array).
     * 		NOTICE: SNS knows "expired" locations. These ones are not returned !
     */
    Location[] findLocationsFromQueryTerm(String queryTerm, QueryType typeOfQuery,
    		MatchingType matching, Locale language);

    /**
     * Classify a text meaning identify gazetteer locations describing the text.
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul>
     * <li>used in Portal Extended Search for look up of locations from arbitrary
     * entered text see<br/>
     * PortalU: http://localhost:8080/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text and click "Look-up Geographic Names"
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_autoclassifytext.html?lang=en
     * </br>NOTICE: not all parameters are part of web UI.
     * </ul>
     * @param text any kind of text to classify
     * @param analyzeMaxWords The maximal number of words to analyze.
     * 		If the document contains more words these will be ignored
     * @param ignoreCase Set to true to ignore capitalization of the text
     * @param language language of the text and the results.
     * @return Array of Locations found for text (or empty array).
     * 		NOTICE: SNS knows "expired" locations. These ones are not returned !
     */
    Location[] getLocationsFromText(String text, int analyzeMaxWords, boolean ignoreCase, Locale language);

    /**
     * Get all related gazetteer locations of a given gazetteer location.
     * <ul>
     * <li>used in Portal Extended Search for showing associated locations of a
     * given location, e.g. showing capital city of a country.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text, click "Look-up Geographic Names" and click on found location
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_getpsi.html?lang=en
     * </br>NOTICE: we always target topics of type "/location" (=Location Entry)
     * </ul>
     * @param fromLocationId the unique identifier of a location to find related locations for
     * @param includeFrom should the location with the passed fromLocationId also be included in  the results ?</br>
     * 		true=location is included and is <b>FIRST</b> location in result array</br>
     * 		false=location is NOT included, first location in array is arbitrary location.
     * @param language which language. NOTICE: may be ignored if locationId already determines language !
     * @return Array of related locations for passed location (or empty array)
     * 		NOTICE: SNS knows "expired" locations. These ones are not returned !</br>
     * 		If passed <code>includeFrom</code> is true the the first location in array is location with
     * 		passed <code>fromLocationId</code> (but NOT if that one is "expired", only non "expired" locations
     * 		are returned !).
     */
    Location[] getRelatedLocationsFromLocation(String fromLocationId, boolean includeFrom, Locale language);

    /**
     * Get location with given id.
     * <ul>
     * <li>used in IGE to read location from id.
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_getpsi.html?lang=en
     * </br>NOTICE: we always target topics of type "/location" (=Location Entry)
     * </ul>
     * @param locationId the unique identifier of the location in gazetteer
     * @param language which language to fetch. NOTICE: may be ignored if locationId already determines language !
     * @return the found location or null if not found.
     * 		NOTICE: SNS knows "expired" locations. We always return the location found no matter
     * 		whether expired or not ! The location contains expired info (<code>isExpired</code>).
     */
    Location getLocation(String locationId, Locale language);
}
