package de.ingrid.external.om.impl;

import java.util.ArrayList;
import java.util.List;

import de.ingrid.external.om.Term;
import de.ingrid.external.om.TreeTerm;

/**
 * Default Implementation of TreeTerm Interface.
 */
public class TreeTermImpl extends TermImpl implements TreeTerm {

	private Term parent;
	private List<Term> children;

	@Override
	public List<Term> getChildren() {
		return children;
	}

	@Override
	public void addChild(Term child) {
		if (children == null) {
			children = new ArrayList<Term>();
		}
		children.add(child);
	}

	@Override
	public Term getParent() {
		return parent;
	}

	@Override
	public void setParent(Term parent) {
		this.parent = parent;
	}

	public String toString() {
		String result = super.toString() + " ";
		result += "parent: "+ ((this.parent != null) ? parent.getId() : null);
		result += ", children: "+ ((this.children != null) ? children.size() : null);

		return result;
	}
}
