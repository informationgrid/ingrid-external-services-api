/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.Date;

/**
 * Representation of an Anniversary Event.<br>
 * NOTICE: The time reference is set as time range FROM/TO.
 * FROM is never null. If TO is null then the time reference is
 * a single point in time (FROM). If TO is not null and > FROM
 * then the event refers to a time interval [FROM, TO].
 */
public interface AnniversaryEvent {

	/**
	 * Set the lower limit of a time range or a single
	 * point in time. Has to be set ! NEVER NULL !
	 * @param from never NULL, lower limit of time range or a single point in time
	 */
	public void setTimeRangeFrom(Date from);

	/**
	 * Get the lower limit of a time range or a single point in time
	 * @return point in time (the lower limit or a single point, dependent from TO)
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
	 * @return null if there is only a single point in time (FROM)
	 */
	public Date getTimeRangeTo();
}
