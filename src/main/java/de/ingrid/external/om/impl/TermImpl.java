package de.ingrid.external.om.impl;

import java.util.List;

import de.ingrid.external.om.Term;

/**
 * Default Implementation of Term Interface.
 */
public class TermImpl implements Term {

	private String id;
	private String name;
	private TermType type;
	/**	SNS -> GEMET ID if present */
	private String alternateId; 
	/**	SNS -> UMTHES name if different from GEMET name */
	private String alternateName; 
	private List<String> inspireThemes;

	@Override
	public String getAlternateId() {
		return alternateId;
	}

	@Override
	public String getAlternateName() {
		return alternateName;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public TermType getType() {
		return type;
	}

	@Override
	public void setAlternateId(String alternateId) {
		this.alternateId = alternateId;
	}

	@Override
	public void setAlternateName(String alternateName) {
		this.alternateName = alternateName;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setType(TermType type) {
		this.type = type;
	}

	@Override
	public List<String> getInspireThemes() {
		return inspireThemes;
	}

	@Override
	public void setInspireThemes(List<String> inspireThemes) {
		this.inspireThemes = inspireThemes;
	}

	public String toString() {
		String result = "[";
		result += "ID: "+this.id;
		result += ", Name: "+this.name;
		result += ", Type: "+this.type;
		result += ", alternateId: "+this.alternateId;
		result += ", alternateName: "+this.alternateName;
		if (this.inspireThemes != null && this.inspireThemes.size() > 0) {
			result += ", inspireThemes: "+this.inspireThemes;
		}
		result += "]";
		return result;
	}
}
