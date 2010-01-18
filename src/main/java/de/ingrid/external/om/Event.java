/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.Date;

/**
 * Representation of an Event (utilized by SNS).<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>id</code>: arbitrary unique identifier of the event
 * <li><code>title</code>: the title of the event
 * <li><code>time...</code>: the time reference can be set as single point in time (<code>TimeAt</code>) OR<br/>
 * as a time range (interval) [<code>TimeRangeFrom</code>, <code>TimeRangeTo</code>].
 * </ul>
 */
public interface Event {

    /**
     * Set id of the event.
	 * @param id unique identifier of the event, NEVER NULL
     */
    public void setId(String id);

    /**
	 * Get the id of the event.
	 * @return the unique identifier of the event, NEVER NULL
     */
    public String getId();

    /**
	 * Set the title of the event.
     * @param title event title, NEVER NULL
     */
    public void setTitle(String title);

    /**
	 * Get the title of the event.
	 * @return the title of the event, NEVER NULL
     */
    public String getTitle();

    /**
	 * Set the description of the event.
     * @param description event description
     */
    public void setDescription(String description);

    /**
	 * Get the description of the event.
	 * @return the description of the event
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
	 * When not using SNS pass here the full name of the type of the event if you can provide it. 
	 * Otherwise do not set it.
	 * @param typeId the id of the type of the event (utilized in SNS). Pass full name of type
	 * 		if not using SNS.
	 */
	public void setTypeId(String typeId);

	/**
	 * Get the id of the type of the event (utilized in SNS). E.g. in SNS this is an
	 * identifier indicating a Disaster ("disasterType") or Measure ("activityType") ...
	 * When not using SNS the typeId is the full name of the type of the event if set. 
	 * @return the id of the type of the event (utilized in SNS) or NULL.
	 */
	public String getTypeId();
}
