/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.List;

/**
 * Representation of a thesaurus term IN A TREE.
 * Adds additional info about parent and children in hierarchy.<p>
 * Mandatory content (NOT NULL):
 * <ul><li>see <code>Term</code>
 * </ul>
 * Optionally delivered information, dependent from context:
 * <ul><li><code>children</code>: specifies whether the term has children.
 * Determines whether a next hierarchy level can be requested when browsing
 * a tree. May be null if term is leaf OR if not evaluated, e.g. if path to top
 * is requested, then lowest node may not have been evaluated concerning its children.
 * <li><code>parent</code>: specifies whether the term has a parent.
 * May be null if term is top term OR if not evaluated, e.g. if children
 * of a node are requested, then the node may not have been evaluated concerning its parent.
 * </ul>
 */
public interface TreeTerm extends Term {
	
	/**
	 * Add a term as child of this term !
	 * @param child <code>Term</code> added as child of this term !
	 * NOTICE: Not necessarily a <code>TreeTerm</code>, child/parent data in child not needed !</br>
	 */
	public void addChild(Term child);

	/**
	 * Get children of term.
	 * NOTICE: May be null, if not evaluated yet OR if term is leaf !<br/>
	 * @return null=not evaluated yet OR leaf, not null=list of children</br>
	 * NOTICE: Returns <code>Terms</code> (NOT <code>TreeTerms</code>) !
	 * child/parent data in children not necessarily needed !
	 */
	public List<Term> getChildren();

	/**
	 * Add a term as the parent of this term !
	 * @param parent <code>Term</code> set as parent of this term !
	 * NOTICE: Not necessarily a <code>TreeTerm</code>, child/parent data in parent not needed !</br>
	 */
	public void setParent(Term parent);

	/**
	 * Get parent of term.
	 * NOTICE: May be null, if not evaluated yet OR if top node !<br/>
	 * @return null=not evaluated yet OR top node, not null=parent of term</br>
	 * NOTICE: Returns <code>Term</code> (NOT <code>TreeTerm</code>) !
	 * child/parent data in parent not necessarily needed !
	 */
	public Term getParent();
}
