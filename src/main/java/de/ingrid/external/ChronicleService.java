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
     * @param dateStart is the date an event occured or started
     * @param dateEnd is the date an event ended
     * @param language determines the language of the events
     * @param page determines the result page
     * @param length defines how many hits to return
     * @param inCollection defines in which collection the result has to be (historical, activity, ...)
     * @return an all events matching the control parameters
     */
    Event[] findEventsFromQueryTerm(String queryTerm, MatchingType matching, String[] inCollections, String dateStart, String dateEnd, Locale language, int page, int length);

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
