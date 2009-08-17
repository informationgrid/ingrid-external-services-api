/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a SimilarTerm.
 */
public interface SimilarTerm {

	/**
	 * Set the similar term.
	 * @param term
	 */
	public void setTerm(String term);

	/**
	 * Get the similar term
	 * @return the similar term
	 */
	public String getTerm();
}
