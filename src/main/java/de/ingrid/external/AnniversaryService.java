/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import java.util.Date;

import de.ingrid.external.om.AnniversaryEvent;

/**
 * Service for fetching Anniversary Events from external service.
 */
public interface AnniversaryService {

    /**
     * Request Anniversary Events for a given Date.
     * @param date  The date to search anniversaries for.
     * @param lang  The language of the anniversary content.
     * @return array of found anniversary events or EMPTY array.
     */
	AnniversaryEvent[] getAnniversaries(Date date, String language);

}
