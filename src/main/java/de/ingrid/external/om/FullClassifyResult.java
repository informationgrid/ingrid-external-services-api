package de.ingrid.external.om;

import java.util.List;

/**
 * Result of a FULL classify request for a document/url.<p>
 * Contains general info about the document and classified thesaurus terms / gazetteer locations / 
 * events (time information).<br/>
 * Mandatory content (NOT NULL):
 * <ul><li><code>IndexedDocument</code>: Contains general extracted info of the document/url
 * </ul>
 */
public interface FullClassifyResult {

	/**
	 * Get general info about the classified doc.
	 * @return general info. NEVER NULL.
	 */
	public IndexedDocument getIndexedDocument();

	/**
	 * Set general info about the classified doc.
	 * @param indexedDocument infos describing the classified text. NEVER NULL
	 */
	public void setIndexedDocument(IndexedDocument indexedDocument);

	/**
	 * Get the thesaurus terms found in classification.
	 * @return list of thesaurus terms or empty list. NEVER NULL.
	 * 		NOTICE: Only terms of TermType DESCRIPTOR !
	 */
	public List<Term> getTerms();

	/**
	 * Set the thesaurus terms found in classification.
	 * @param terms list of thesaurus terms. NEVER NULL.
	 * 		NOTICE: Only terms of TermType DESCRIPTOR !
	 */
	public void setTerms(List<Term> terms);

	/**
	 * Get the gazetteer locations found in classification.  
	 * @return list of gazetteer locations or empty list. NEVER NULL
	 */
	public List<Location> getLocations();

	/**
	 * Set the gazetteer locations found in classification.  
	 * @param locations list of gazetteer locations or empty list. NEVER NULL
	 */
	public void setLocations(List<Location> locations);

	/**
	 * Get the events (time information) found in classification (utilized by SNS).
	 * @return list of events or empty list. NEVER NULL
	 */
	public List<Event> getEvents();

	/**
	 * Set the events (time information) found in classification (utilized by SNS).  
	 * @param events list of events or empty list. NEVER NULL
	 */
	public void setEvents(List<Event> events);
}
