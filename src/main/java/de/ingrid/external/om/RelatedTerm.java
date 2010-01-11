/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a thesaurus term related to another thesaurus term.
 * Adds additional information about the relation.<p>
 * Mandatory content (NOT NULL):
 * <ul><li>see <code>Term</code>
 * <li><code>relationType</code>: the type of the relation.
 * </ul>
 */
public interface RelatedTerm extends Term {
	
	/** Type of the relation of <code>this</code> term to another term. */
	public enum RelationType {
		/** term is a parent */
		PARENT,
		/** term is a child */
		CHILD,
		/** term is somehow connected (e.g. is a synonym when utilizing SNS) */
		RELATIVE;
	}

	/**
	 * Set the type of the relation of <code>this</code> term to another term.
	 * @param type type of relation of <code>this</code> term, NOT NULL
	 */
	public void setRelationType(RelationType type);

	/**
	 * Get the type of the relation of <code>this</code> term to another term.
	 * @return type of relation of <code>this</code> term, NOT NULL
	 */
	public RelationType getRelationType();
}
