/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import de.ingrid.utils.IngridHitDetail;

/**
 * Service for fetching Information of Anniversary Events.
 */
public interface AnniversaryService {

    /**
     * Returns all found Anniversary of a given Date. This method uses a fallback strategy 
     * of no aniversary was found for a particular day, month. It enlarges the search
     * with the following fallbacks:
     * 
     *  1.) today
     *  2.) this month
     *  3.) year
     * 
     * @param date  The date to search anniveraries for.
     * @param lang  The language of the anniversary content.
     * @return The DetailedTopic Array representing the anniversaries.
     */
    IngridHitDetail[] getAnniversaries(java.util.Date date, String lang);

}
