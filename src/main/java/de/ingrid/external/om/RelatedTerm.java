/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a gazetteer term RELATED TO ANOTHER ONE.
 * Adds additional relation information to the term.<p>
 * Mandatory content (NOT NULL):
 * <ul><li>see <code>Term</code>
 * <li><code>relationType</code>: the type of the relation.
 * </ul>
 */
public interface RelatedTerm extends Term {
	
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
