/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a related gazetteer term.
 * Specifies the term itself and the type of its relation.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>relatedTerm</code>: the related term.
 * <li><code>relationType</code>: the type of the relation.
 * </ul>
 */
public interface RelatedTerm {
	
	/** Type of the relation of this term */
	public enum RelationType {
		/** term is a parent */
		PARENT,
		/** term is a child */
		CHILD,
		/** term is somehow connected (e.g. sibling or something else) */
		RELATIVE;
	}

	/**
	 * Set the term.
	 * @param term the related term, NOT NULL
	 */
	public void setTerm(Term term);

	/**
	 * Get the term.
	 * @return the related term, NOT NULL
	 */
	public Term getTerm();

	/**
	 * Set the type of the relation of this term.
	 * @param type type of relation of this term, NOT NULL
	 */
	public void setRelationType(RelationType type);

	/**
	 * Get the type of the relation of this term.
	 * @return type of relation of this term, NOT NULL
	 */
	public RelationType getRelationType();
}
