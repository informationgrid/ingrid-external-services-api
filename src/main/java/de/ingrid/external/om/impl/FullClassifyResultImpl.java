package de.ingrid.external.om.impl;

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
		if (this.locations != null) {
			result += ", Locations: "+this.locations;
		}
		if (this.terms != null) {
			result += ", Terms: "+this.terms;
		}
		if (this.events != null) {
			result += ", Events: "+this.events;
		}
		result += "]";
		return result;
	}
}
