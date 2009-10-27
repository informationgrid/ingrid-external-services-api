/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a thesaurus term in a tree.
 * Specifies the term itself and tree information.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>term</code>: the term in the tree.
 * </ul>
 * Optionally delivered information, dependent from context:
 * <ul><li><code>hasChildren</code>: specifies whether the term has children.
 * Determines whether a next hierarchy level can be requested when browsing
 * a tree. May not be set, e.g. if path to top is requested, then lowest node
 * may not have been evaluated yet concerning its children.
 * <li><code>hasParent</code>: specifies whether the term has a parent (is top
 * node or not). May not be set, e.g. if children of a node are requested, then
 * the node may not have been evaluated concerning its parent. 
 * </ul>
 */
public interface TreeTerm {
	
	/**
	 * Set the term. NOTICE: Term can be of different type ("label" ...).
	 * @param term the tree term, NOT NULL
	 */
	public void setTerm(Term term);

	/**
	 * Get the term. NOTICE: Term can be of different type ("label" ...).
	 * @return the tree term, NOT NULL
	 */
	public Term getTerm();

	/**
	 * Set whether the term has a parent.
	 * @param hasParent true=term has a parent, false=term is top node
	 */
	public void setHasParent(boolean hasParent);

	/**
	 * Get info whether term has a parent.
	 * @return true=term has a parent, false=term is top node, NULL=not evaluated yet
	 */
	public Boolean getHasParent();

	/**
	 * Set whether term has subterms.
	 * @param hasChildren true=term has subterms, false=term is leaf
	 */
	public void setHasChildren(boolean hasChildren);

	/**
	 * Get info whether term has subterms.<br/>
	 * Determines whether a next hierarchy level can be requested when browsing a tree.
	 * @return true=term has subterms, false=term is leaf, null=not evaluated yet
	 */
	public Boolean getHasChildren();
}
