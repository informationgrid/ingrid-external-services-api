/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2015 wemove digital solutions GmbH
 * ==================================================
 * Licensed under the EUPL, Version 1.1 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 * 
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl5
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
import java.util.List;

import de.ingrid.external.om.Event;
import de.ingrid.external.om.FullClassifyResult;
import de.ingrid.external.om.IndexedDocument;
import de.ingrid.external.om.Location;
import de.ingrid.external.om.Term;

/**
 * Default Implementation of FullClassifyResult Interface.
 */
public class FullClassifyResultImpl implements FullClassifyResult {

	private IndexedDocument indexedDocument;
	private List<Location> locations;
	private List<Term> terms;
	private List<Event> events;

	public FullClassifyResultImpl() {
		locations = new ArrayList<Location>();
		terms = new ArrayList<Term>();
		events = new ArrayList<Event>();
	}

	@Override
	public IndexedDocument getIndexedDocument() {
		return indexedDocument;
	}

	@Override
	public List<Location> getLocations() {
		return locations;
	}

	@Override
	public List<Term> getTerms() {
		return terms;
	}

	@Override
	public List<Event> getEvents() {
		return events;
	}

	@Override
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	@Override
	public void setIndexedDocument(IndexedDocument indexedDocument) {
		this.indexedDocument = indexedDocument;
	}

	@Override
	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

	@Override
	public void setTerms(List<Term> terms) {
		this.terms = terms;
	}

	public String toString() {
		String result = "[";
		result += "IndexedDocument: " + this.indexedDocument;
		if (this.locations.size() > 0) {
			result += ", Locations: "+this.locations;
		}
		if (this.terms.size() > 0) {
			result += ", Terms: "+this.terms;
		}
		if (this.events.size() > 0) {
			result += ", Events: "+this.events;
		}
		result += "]";
		return result;
	}
}
