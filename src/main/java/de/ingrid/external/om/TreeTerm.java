/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * A term in a tree specifying the term and tree information.
 */
public interface TreeTerm {
	
	/**
	 * Set the tree term. NOTICE: Can also be a label and no real term,
	 * see below <code>setIsLabel</code>
	 * @param term the tree term
	 */
	public void setTerm(Term term);

	/**
	 * Get the tree term. NOTICE: Can also be a label and no real term,
	 * see below <code>setIsLabel</code>
	 * @return the tree term
	 */
	public Term getTerm();

	/**
	 * Set whether term has subterms.
	 * @param hasChildren true=term has subterms, false=term is leaf
	 */
	public void setHasChildren(boolean hasChildren);

	/**
	 * Get info whether term has subterms.
	 * return true=term has subterms, false=term is leaf
	 */
	public boolean getHasChildren();

	/**
	 * Set whether the "term" is a label, meaning it's just a label in the tree
	 * hierarchy and cannot be clicked.
	 * @param isLabel true=no term, just a label, false=real term which can be clicked
	 */
	public void setIsLabel(boolean isLabel);

	/**
	 * Get whether the "term" is a label, meaning it's just a label in the tree
	 * hierarchy and cannot be clicked.
	 * return true=no term, just a label, false=real term which can be clicked
	 */
	public boolean getIsLabel();
}
