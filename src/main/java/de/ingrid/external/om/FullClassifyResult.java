package de.ingrid.external.om;

import java.util.List;

/**
 * Result of a FULL classify request for a document or url.<p>
 * Contains info about the document and found thesaurus terms / gazetteer locations etc.<br/>
 * Mandatory content (NOT NULL):
 * <ul><li><code>IndexedDocument</code>: Contains general extracted info of the document/url
 * </ul>
 */
public interface FullClassifyResult {

	/**
	 * Get general info about the classified doc.
	 * @return general info, NEVER NULL
	 */
	public IndexedDocument getIndexedDocument();

	/**
	 * Set general info about the classified doc.
	 * @param indexedDocument infos describing the classified text
	 */
	public void setIndexedDocument(IndexedDocument indexedDocument);

	/**
	 * Get the thesaurus terms found in classification.  
	 * @return list of thesaurus terms
	 */
	public List<Term> getTerms();

	/**
	 * Set the thesaurus terms found in classification.  
	 * @param terms list of thesaurus terms
	 */
	public void setTerms(List<Term> terms);

	/**
	 * Get the gazetteer locations found in classification.  
	 * @return list of gazetteer locations
	 */
	public List<Location> getLocations();

	/**
	 * Set the gazetteer locations found in classification.  
	 * @param locations list of gazetteer locations
	 */
	public void setLocations(List<Location> locations);

	/**
	 * Get the events found in classification (utilized by SNS).
	 * @return list of events
	 */
	public List<Event> getEvents();

	/**
	 * Set the events found in classification (utilized by SNS).  
	 * @param events list of events
	 */
	public void setEvents(List<Event> events);
}
