/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2024 wemove digital solutions GmbH
 * ==================================================
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 * 
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * https://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * **************************************************#
 */
package de.ingrid.external.om.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.ingrid.external.om.Event;
import de.ingrid.external.om.Link;

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
	private List<Link> links = new ArrayList<Link>();

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

	@Override
	public List<Link> getLinks() {
		return links;
	}

	@Override
	public void addLink(Link link) {
		links.add(link);		
	}
}
