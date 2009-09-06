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
	 * @param id unique identifier of the term in the thesaurus
	 */
	public void setId(String id);

	/**
	 * Get the id of the term.
	 * @return the unique identifier of the term in the thesaurus
	 */
	public String getId();

	/**
	 * Set the term name.
	 * @param name the name of the term
	 */
	public void setName(String name);

	/**
	 * Get the name of the term.
	 * @return the name of the term
	 */
	public String getName();
}
