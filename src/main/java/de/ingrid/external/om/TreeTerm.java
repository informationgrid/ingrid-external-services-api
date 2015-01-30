/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2015 wemove digital solutions GmbH
 * ==================================================
 * Licensed under the EUPL, Version 1.1 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 * 
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * http://ec.europa.eu/idabc/eupl5
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * **************************************************#
 */
/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

import java.util.List;

/**
 * Representation of a thesaurus term IN A TREE used for all HIERARCHY OPERATIONS !
 * Adds additional info about parents and children to the term.
 * NOTICE: a node can have multiple parents !<p>
 * Mandatory content:
 * <ul><li>see <code>Term</code>
 * <li><code>parents</code>: specifies whether the term has a parent.</br>
 * A node can have multiple parents. If NULL then the term is a top node !
 * NOTICE: In all hierarchy operations at least one parent is evaluated, so this
 * is only null if the term is a top node, see <code>getParent</code>.
 * </ul>
 * Optionally delivered information, dependent from context:
 * <ul><li><code>children</code>: specifies whether the term has children.</br>
 * Determines whether a next hierarchy level can be requested when browsing
 * a tree. May be null if term is leaf OR if not evaluated yet, see <code>getChildren</code>.
 * </ul>
 */
public interface TreeTerm extends Term {
	
	/**
	 * Add a term as child of THIS term !
	 * <b>NOTICE: THIS term should also be added as parent to the child !!!</b>
	 * @param child <code>TreeTerm</code> added as child of this term !
	 */
	public void addChild(TreeTerm child);

	/**
	 * Get children of term.
	 * NOTICE: May be null, if not evaluated yet OR if term is leaf ! This depends
	 * on context, e.g. if path to top was requested, then lowest node is not evaluated
	 * concerning its children (null). But if next hierarchy downwards was requested
	 * and a child does NOT have children (null), then it's a leaf (next hierarchy fetches 2
	 * hierarchy levels).<br/>
	 * @return <b>null</b>=not evaluated yet OR leaf</br>
	 * 		<b>not null</b>=list of children. NOTICE: The list of children may not be complete, only
	 * the children determined from request are added ! e.g. when path to top is requested, the
	 * parents only have the child in the path in their children list (no siblings).
	 */
	public List<TreeTerm> getChildren();

	/**
	 * Add a term as the parent of THIS term ! A term can have multiple parents. 
	 * <b>NOTICE: THIS term should also be added as child to the parent !!!</b>
	 * @param parent <code>TreeTerm</code> added as parent of this term !
	 */
	public void addParent(TreeTerm parent);

	/**
	 * Get parents of term. A Term can have multiple parents.
	 * NOTICE: Is null if term is top node ! If path to top was requested, then all nodes
	 * in hierarchy contain their parents and null means top node ! If next hierarchy
	 * downwards was requested (via ID of parent term), then all direct children contain
	 * their parent term (the one with the mentioned ID).<br/>
	 * @return <b>null</b>=top node</br>
	 * 		<b>not null</b>=list of parents. NOTICE: The list of parents may not be complete, only
	 * the parents determined from request are added ! e.g. when next hierarchy level is requested
	 * the children only have the starting parent in their parent list.
	 */
	public List<TreeTerm> getParents();
}
