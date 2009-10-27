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
     * Analyze text extracting locations.
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul><li>used in Portal Extended Search for look up of locations from arbitrary
     * entered text see<br/>
     * PortalU: http://localhost:8080/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text and click "Look-up Geographic Names"
     * </ul>
     * @param text arbitrary text to classify. Multiple words, sentences etc.
     * @param analyzeMaxWords The maximum number of words to analyze
     * @param ignoreCase Set to true to ignore capitalization of the text
     * @param language language of the text and the results. If passed language can't be processed
     * 		or is null then default language may be used (PortalU: de, GS Soil: en)
     * @return Array of Locations found for text (or empty array).
     */
    Location[] getLocationsFromText(String text, int analyzeMaxWords, boolean ignoreCase, Locale language);
}
