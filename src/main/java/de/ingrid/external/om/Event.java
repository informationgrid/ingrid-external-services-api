/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.Date;

/**
 * An Event represents time information with which a document/url can be classified.
 * This can be a concrete incident in time or some info about the historical context (SNS).
 * This data is used for enrichment of the search index with time references.<p>
 * An Event in the API may be only used for adding a time reference without any further
 * information (no real event). If so, you do not have to add an ID or TITLE or TYPE
 * (the event can not be reproduced then).<p>
 * Mandatory content:
 * <ul><li><code>time...</code>: the time reference. Can be set as single point in time (<code>TimeAt</code>) OR<br/>
 * as a time range (interval) [<code>TimeRangeFrom</code>, <code>TimeRangeTo</code>]. This data
 * is added to the search index !
 * </ul>
 */
public interface Event {

    /**
     * Set id of the event. If you just want to add a time reference for indexing
     * do not set the Id.
	 * @param id unique identifier of the event or NULL (if "event" is just a time reference)
     */
    public void setId(String id);

    /**
	 * Get the id of the event.
	 * @return the unique identifier of the event or NULL (if "event" is just a time reference)
     */
    public String getId();

    /**
	 * Set the title of the event. If you just want to add a time reference
	 * for indexing do not set the title.
     * @param title event title or NULL (if "event" is just a time reference)
     */
    public void setTitle(String title);

    /**
	 * Get the title of the event.
	 * @return the title of the event or NULL (if "event" is just a time reference)
     */
    public String getTitle();

    /**
	 * Set the description of the event.
     * @param description event description
     */
    public void setDescription(String description);

    /**
	 * Get the description of the event.
	 * @return the description of the event or NULL
     */
    public String getDescription();

	/**
	 * Set the exact date of the event (if no time range)
	 * @param at exact date of event
	 */
	public void setTimeAt(Date at);

	/**
	 * Get the exact date of the event.
	 * @return exact date of the event OR NULL (if event is in time range)
	 */
	public Date getTimeAt();

	/**
	 * Set the lower limit of a time range.
	 * @param from lower limit of time range
	 */
	public void setTimeRangeFrom(Date from);

	/**
	 * Get the lower limit of a time range.
	 * @return lower limit of time range OR NULL (if event is single point in time)
	 */
	public Date getTimeRangeFrom();

	/**
	 * Set the upper limit of a time range.  
	 * @param to upperLimit of a time range
	 */
	public void setTimeRangeTo(Date to);

	/**
	 * Get the upper limit of a time range.
	 * @return upper limit of time range OR NULL (if event is single point in time)
	 */
	public Date getTimeRangeTo();

	/**
	 * Set the id of the type of the event (utilized in SNS). E.g. in SNS this is an
	 * identifier indicating a Disaster ("disasterType") or Measure ("activityType") ...
	 * When not using SNS pass here the full name of the type of the event if you can
	 * provide it. Otherwise do not set it.
	 * @param typeId the id of the type of the event (utilized in SNS). Pass full name of type
	 * 		if not using SNS.
	 */
	public void setTypeId(String typeId);

	/**
	 * Get the id of the type of the event (utilized in SNS). E.g. in SNS this is an
	 * identifier indicating a Disaster ("disasterType") or Measure ("activityType") ...
	 * When not using SNS the typeId may be the full name of the type of the event if set. 
	 * @return the id of the type of the event (utilized in SNS) or NULL. If not using SNS
	 * 		the typeId may be the full name of the type.
	 */
	public String getTypeId();
}
