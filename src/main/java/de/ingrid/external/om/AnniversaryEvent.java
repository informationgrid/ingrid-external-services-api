/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.Date;

/**
 * Representation of an Anniversary Event.<p>
 * Mandatory content:
 * <ul><li>Id<li>language<li>title<li>timeRangeFrom<br>
 * NOTICE: The time reference is set as time range FROM/TO.
 * FROM is never null. If TO is null then the time reference is
 * a single point in time (FROM). If TO is not null and > FROM
 * then the event refers to a time interval [FROM, TO].
 * </ul>
 */
public interface AnniversaryEvent {

    /**
     * Set id of event. The event can always be requested via this Id. 
     * @param id id of event used for fetching from service.
     */
    public void setId(String id);

    /**
     * @return NEVER NULL. id of event (used for fetching event from service).
     */
    public String getId();

    /**
     * Title of Event.
     * @param title event title
     */
    public void setTitle(String title);

    /**
     * @return NEVER NULL. title of event
     */
    public String getTitle();

    /**
     * Set language of the event in ISO 639-1 (Alpha-2 code)
     * @param lang language as 2 letter iso code 
     */
    public void setLanguage(String lang);

    /**
     * @return NEVER NULL. 2 letter ISO 639-1 code of language of event.
     */
    public String getLanguage();

	/**
	 * Set the lower limit of a time range or a single
	 * point in time. Has to be set ! NEVER NULL !
	 * @param from NEVER NULL, lower limit of time range or a single point in time
	 */
	public void setTimeRangeFrom(Date from);

	/**
	 * Get the lower limit of a time range or a single point in time
	 * @return NEVER NULL. point in time (the lower limit of time range or a single point, dependent from TO)
	 */
	public Date getTimeRangeFrom();

	/**
	 * Set the upper limit of a time range.
	 * Pass NULL if there is no time range and the lower limit
	 * specifies the single point in time of the event.  
	 * @param to upperLimit of a time range or null
	 */
	public void setTimeRangeTo(Date to);

	/**
	 * Get the upper limit of a time range.
	 * @return null if there is only a single point in time (FROM) else upper limit of time range
	 */
	public Date getTimeRangeTo();
}
