/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * A term in a tree specifying the term and tree information.<p>
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
	 * Set whether term has a parent.
	 * @param hasParent true=term has a parent, false=term is top node
	 */
	public void setHasParent(boolean hasParent);

	/**
	 * Get info whether term has a parent.
	 * return true=term has a parent, false=term is top node, null=not evaluated yet
	 */
	public Boolean getHasParent();

	/**
	 * Set whether term has subterms.
	 * @param hasChildren true=term has subterms, false=term is leaf
	 */
	public void setHasChildren(boolean hasChildren);

	/**
	 * Get info whether term has subterms.
	 * return true=term has subterms, false=term is leaf, null=not evaluated yet
	 */
	public Boolean getHasChildren();
}
