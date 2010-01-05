/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.List;

/**
 * Basic semantic unit of a Thesaurus.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>id</code>: arbitrary unique identifier of the term in the thesaurus 
 * <li><code>type</code>: the type of the term.
 * <li><code>name</code>: the name of the term
 * </ul>
 */
public interface Term {

	/** Type of the term. */
	public enum TermType {
		/** the term is a fully qualified term and can be used as a describing
		 * term in meta data. The standard ! */
		DESCRIPTOR,
		/** the term is just a synonym for another term and should not be used
		 * as a describing term in meta data (utilized in SNS) */
		NON_DESCRIPTOR,
		/** the term is just a label in the hierarchy and should not be used
		 * as a describing term in meta data (utilized in SNS) */
		NODE_LABEL;
	}

	/**
	 * Set the type of the term.
	 * @param type type of term, NEVER NULL
	 */
	public void setType(TermType type);

	/**
	 * Get the type of the term.
	 * @return type of term, NEVER NULL
	 */
	public TermType getType();

	/**
	 * Set the id of the term. 
	 * @param id unique identifier of the term in the thesaurus, NEVER NULL
	 */
	public void setId(String id);

	/**
	 * Get the id of the term.
	 * @return the unique identifier of the term in the thesaurus, NEVER NULL
	 */
	public String getId();

	/**
	 * Set the term name.
	 * @param name the name of the term, NEVER NULL
	 */
	public void setName(String name);

	/**
	 * Get the name of the term.
	 * @return the name of the term, NEVER NULL
	 */
	public String getName();

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Set the alternate id of the term if present.<br/>
	 * Utilized in SNS where ONE term can have different ids dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the GEMET id if term has GEMET representation.
	 * @param alternateId the alternate id of the term (utilized in SNS). NULL per default. 
	 */
	public void setAlternateId(String alternateId);

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Get the alternate id of the term if present.<br/>
	 * Utilized in SNS where ONE term can have different ids dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the GEMET id if term has GEMET representation.
	 * @return the alternate id of the term if present (utilized in SNS). NULL per default. 
	 */
	public String getAlternateId();

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Set the alternate name of the term if present.<br/>
	 * Utilized in SNS where a term can have a different name dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the UMTHES name if term has GEMET representation.
	 * @param alternateName the alternate name of the term (utilized in SNS). NULL per default. 
	 */
	public void setAlternateName(String alternateName);

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Get the alternate name of the term if present.<br/>
	 * Utilized in SNS where a term can have a different name dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the UMTHES name if term has GEMET representation.
	 * @return the alternate name of the term if present (utilized in SNS). NULL per default. 
	 */
	public String getAlternateName();

	/**
	 * Set a list of Inspire Themes the term is related to (utilized in SNS).
	 * @param inspireThemes list of inspire themes
	 */
	public void setInspireThemes(List<String> inspireThemes);

	/**
	 * Get a list of Inspire Themes the term is related to (utilized in SNS).
	 * @return list of inspire themes. NULL per default
	 */
	public List<String> getInspireThemes();
}
