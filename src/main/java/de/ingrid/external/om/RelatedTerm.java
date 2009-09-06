/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * A related term specifying the term and the type of the relation.
 */
public interface RelatedTerm {
	
	/** Type of the relation to the term */
	public enum RelationType {
		/** the related term is a synonym and should not be used as describing term (SNS specific) */
		SYNONYM,
		/** the related term is a parent */
		PARENT,
		/** the related term is a child */
		CHILD,
		/** the related term is a sibling */
		SIBLING;
	}

	/**
	 * Set the related term. 
	 * @param term the related term
	 */
	public void setRelatedTerm(Term term);

	/**
	 * Get the related term.
	 * @return the related term
	 */
	public Term getRelatedTerm();

	/**
	 * Set the type of the relation.
	 * @param type type of relation
	 */
	public void setRelationType(RelationType type);

	/**
	 * Get the type of the relation.
	 * @return type of relation
	 */
	public RelationType getRelationType();
}
