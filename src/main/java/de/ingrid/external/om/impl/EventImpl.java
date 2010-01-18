package de.ingrid.external.om.impl;

import java.util.Date;

import de.ingrid.external.om.Event;

/**
 * Default Implementation of Event Interface.
 */
public class EventImpl implements Event {

	private String id;
	private String typeId;	 // e.g. for SNS: activityType, disasterType, ... 
	private String title;
	private String description;
	private Date timeAt;
	private Date timeFrom;
	private Date timeTo;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public Date getTimeAt() {
		return timeAt;
	}

	@Override
	public Date getTimeRangeFrom() {
		return timeFrom;
	}

	@Override
	public Date getTimeRangeTo() {
		return timeTo;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getTypeId() {
		return typeId;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setTimeAt(Date at) {
		this.timeAt = at;
	}

	@Override
	public void setTimeRangeFrom(Date from) {
		this.timeFrom = from;
	}

	@Override
	public void setTimeRangeTo(Date to) {
		this.timeTo = to;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String toString() {
		String result = "[";
		result += "ID: "+this.id;
		result += ", Title: "+this.title;
		result += ", Type ID: "+this.typeId;
		result += ", Description: "+this.description;
		result += ", TimeAt: "+this.timeAt;
		result += ", TimeFrom: "+this.timeFrom;
		result += ", TimeTo: "+this.timeTo;
		result += "]";
		return result;
	}
}
