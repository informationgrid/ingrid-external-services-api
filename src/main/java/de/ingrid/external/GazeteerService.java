/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.Location;


/**
 * Abstract interface (API) for accessing gazetteer.
 * The semantic unit of the gazetteer is a <code>Location</code> encapsulating all relevant data.
 */
public interface GazeteerService {

    /**
     * Get all related locations for a given location.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text, click "Look-up Geographic Names" and click on found location
     * @param locationId the unique identifier of the source location
     * @param language which language, pass null if default language
     * @return Array of related locations found for passed location (or empty array)
     */
    Location[] getRelatedLocationsFromLocation(String locationId, Locale language);

    /**
     * Analyze text extracting locations.
     * When using SNS the autoclassify method of SNS is used.
     * PortalU: http://localhost:8080/ingrid-portal/portal/search-extended/search-ext-env-place-geothesaurus.psml
     * <br/>Enter text and click "Look-up Geographic Names"
     * @param text The text to classify. Multiple words, sentences etc.
     * @param language which language, pass null if default language
     * @return Array of Locations found for text (or empty array)
     */
    Location[] getLocationsFromText(String text, Locale language);
}
