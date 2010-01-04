package de.ingrid.external.om.impl;

import java.util.ArrayList;
import java.util.List;

import de.ingrid.external.om.TreeTerm;

/**
 * Default Implementation of TreeTerm Interface.
 */
public class TreeTermImpl extends TermImpl implements TreeTerm {

	private List<TreeTerm> parents;
	private List<TreeTerm> children;

	@Override
	public List<TreeTerm> getChildren() {
		return children;
	}

	@Override
	public void addChild(TreeTerm child) {
		if (children == null) {
			children = new ArrayList<TreeTerm>();
		}
		children.add(child);
	}

	@Override
	public List<TreeTerm> getParents() {
		return parents;
	}

	@Override
	public void addParent(TreeTerm parent) {
		if (parents == null) {
			parents = new ArrayList<TreeTerm>();
		}
		parents.add(parent);
	}

	public String toString() {
		String result = super.toString() + " ";
		result += "parents: "+ ((this.parents != null) ? parents.size() : null);
		result += ", children: "+ ((this.children != null) ? children.size() : null);

		return result;
	}
}
