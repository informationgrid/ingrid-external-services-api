/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a Thesaurus term.
 */
public interface Term {

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
	 * Set the alternate id of the term if present.
	 * E.g. in SNS, ONE term can have different ids from different thesauri ! 
	 * @param alternateId the alternate id of the term. Null per default. 
	 */
	public void setAlternateId(String alternateId);

	/**
	 * Get the alternate id of the term if present.
	 * E.g. in SNS, ONE term can have different ids from different thesauri ! 
	 * return the alternate id of the term if present. Null per default. 
	 */
	public String getAlternateId();

	/**
	 * Set the alternate name of the term if present.
	 * E.g. in SNS, ONE term can have different names from different thesauri ! 
	 * @param alternateName the alternate name of the term. Null per default. 
	 */
	public void setAlternateName(String alternateName);

	/**
	 * Get the alternate name of the term if present.
	 * E.g. in SNS, ONE term can have different names from different thesauri ! 
	 * return the alternate name of the term if present. Null per default. 
	 */
	public String getAlternateName();
}
