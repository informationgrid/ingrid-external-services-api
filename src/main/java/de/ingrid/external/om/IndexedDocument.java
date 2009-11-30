package de.ingrid.external.om;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

/**
 * Part of the result of a FULL classify request for a document or url.<p>
 * Contains general extracted info of the document/url.
  * Mandatory content (NOT NULL):
 * <ul><li><code>ClassifyTimeStamp</code>: the date the classification was executed
 * </ul>
*/
public interface IndexedDocument {

	/**
	 * Get the extracted title of the document.
	 * @return extracted title or null
	 */
	public String getTitle();

	/**
	 * Set the extracted title of the document.
	 * @param title the extracted title
	 */
	public void setTitle(String title);

	/**
	 * Get the extracted description/abstract of the document.
	 * @return extracted description/abstract or null
	 */
	public String getDescription();

	/**
	 * Set the extracted description/abstract of the document.
	 * @param description extracted description/abstract
	 */
	public void setDescription(String description);

	/**
	 * Get the URL of the document (if web document was classified)
	 * @return URL or null
	 */
	public URL getURL();

	/**
	 * Set the URL of the document (if web document was classified)
	 * @param url URL of the web document
	 */
	public void setURL(URL url);

	/**
	 * Get the extracted language of the document.
	 * @return extracted language or null
	 */
	public Locale getLang();

	/**
	 * Set the extracted language of the document.
	 * @param lang extracted language
	 */
	public void setLang(Locale lang);


	/**
	 * Get the extracted "exact time reference" of the document. 
	 * @return extracted "exact time reference" or null
	 */
	public Date getTimeAt();

	/**
	 * Set the extracted "exact time reference" of the document. 
	 * @param at extracted "exact time reference"
	 */
	public void setTimeAt(Date at);

	/**
	 * Get the extracted "from time reference" of the document.
	 * Only if the time reference is an interval (from, to). 
	 * @return the extracted "from time reference" (start point) or null
	 */
	public Date getTimeFrom();

	/**
	 * Set the extracted "from time reference" of the document.
	 * Only if the time reference is an interval (from, to). 
	 * @param from the extracted "from time reference" (start point)
	 */
	public void setTimeFrom(Date from);

	/**
	 * Get the extracted "to time reference" of the document.
	 * Only if the time reference is an interval (from, to). 
	 * @return the extracted "to time reference" (end point) or null
	 */
	public Date getTimeTo();

	/**
	 * Set the extracted "to time reference" of the document.
	 * Only if the time reference is an interval (from, to). 
	 * @param to the extracted "to time reference" (end point)
	 */
	public void setTimeTo(Date to);

	/**
	 * Get the date when the classification was executed.
	 * @return date when the classification was executed, never null
	 */
	public Date getClassifyTimeStamp();

	/**
	 * Set the date when the classification was executed.
	 * @param timeStamp date when the classification was executed, never null
	 */
	public void setClassifyTimeStamp(Date timeStamp);
}
