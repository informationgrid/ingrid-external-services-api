package de.ingrid.external.om.impl;

import de.ingrid.external.om.RelatedTerm;

/**
 * Default Implementation of RelatedTerm Interface.
 */
public class RelatedTermImpl extends TermImpl implements RelatedTerm {

	private RelationType relationType;
	
	@Override
	public RelationType getRelationType() {
		return relationType;
	}

	@Override
	public void setRelationType(RelationType type) {
		this.relationType = type;
	}

	public String toString() {
		String result = "relationType: " + this.relationType + " " + super.toString();
		return result;
	}
}
