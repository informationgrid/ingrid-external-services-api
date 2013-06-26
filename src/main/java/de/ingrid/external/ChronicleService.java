/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.Event;


/**
 * Interface (API) for accessing chronicle.<p>
 * The basic semantic unit of the chronicle is a <code>Event</code> encapsulating location data.
 */
public interface ChronicleService {

	/** When searching for events in chronicle with a given input name.
	 * How should the event match the input ? Only needed when requesting special search (findEvents...)*/
	public enum MatchingType {
		/** the location contains the input */
		CONTAINS,
		/** the location begins with the input */
		BEGINS_WITH,
		/** the location exactly matches the input */
		EXACT;
	}

    /**
     * Search for events by a given queryTerm. The search result can be controlled by the specification 
     * of the <code>MatchingType</code> and an optional start and end date.
     * 
     * @param queryTerm is the term to be searched for
     * @param matching is the type of search (exact, contains, begins_with)
     * @param inCollection defines in which collection the result has to be (historical, activity, ...)
     * @param dateStart is the date an event occured or started
     * @param dateEnd is the date an event ended
     * @param language determines the language of the events
     * @return an all events matching the control parameters
     */
    Event[] findEventsFromQueryTerm(String queryTerm, MatchingType matching, String[] inCollections, String dateStart, String dateEnd, Locale language);

    /**
     * Get all anniversaries that happened on a specific date (day and month). The date should be
     * in the format "yyyy-mm-dd".
     * @param date is the date in the format "yyyy-mm-dd"
     * @param language is the language of the found events
     * @return all events happened on a specific date
     */
    Event[] getAnniversaries(String date, Locale language);
    
    /**
     * Get a specific event by its ID.
     * @param eventId is the id of an event
     * @param language is the language the event shall be returned
     * @return a specific event
     */
    Event getEvent(String eventId, Locale language);

}
