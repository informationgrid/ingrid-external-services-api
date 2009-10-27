package de.ingrid.external.om;

import java.util.List;

/**
 * Result of a FULL classify request for a document or url.<p>
 * Contains info about the document and found thesaurus terms / gazetteer locations.
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
	 * @return list of thesaurus terms or empty list
	 */
	public List<Term> getTerms();

	/**
	 * Set the thesaurus terms found in classification.  
	 * @param terms list of thesaurus terms or empty list
	 */
	public void setTerms(List<Term> terms);

	/**
	 * Get the gazetteer locations found in classification.  
	 * @return list of gazetteer locations or empty list
	 */
	public List<Location> getLocations();

	/**
	 * Set the gazetteer locations found in classification.  
	 * @param locations list of gazetteer locations or empty list
	 */
	public void setLocations(List<Location> locations);
}
