/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a Thesaurus term.<p>
 */
public interface Term {

	/** Type of the term. */
	public enum TermType {
		/** the term is a fully qualified term and can be used as a describing term. The standard ! */
		DESCRIPTOR,
		/** the term is just a synonym and should not be used as describing term (SNS specific?) */
		NON_DESCRIPTOR,
		/** the term is just a label in the hierarchy and should not be used as describing term (SNS specific?) */
		NODE_LABEL;
	}

	/**
	 * Set the type of the term.
	 * @param type type of term, NEVER NULL
	 */
	public void setType(TermType type);

	/**
	 * Get the type of the term.
	 * @return type of term, NEVER NULL
	 */
	public TermType getType();

	/**
	 * Set the id of the term. 
	 * @param id unique identifier of the term in the thesaurus, NEVER NULL
	 */
	public void setId(String id);

	/**
	 * Get the id of the term.
	 * @return the unique identifier of the term in the thesaurus, NEVER NULL
	 */
	public String getId();

	/**
	 * Set the term name.
	 * @param name the name of the term, NEVER NULL
	 */
	public void setName(String name);

	/**
	 * Get the name of the term.
	 * @return the name of the term, NEVER NULL
	 */
	public String getName();

	/**
	 * Set the alternate id of the term if present.
	 * E.g. in SNS, ONE term can have different ids from different thesauri ! 
	 * @param alternateId the alternate id of the term. Null per default. 
	 */
	public void setAlternateId(String alternateId);

	/**
	 * Get the alternate id of the term if present.
	 * E.g. in SNS, ONE term can have different ids from different thesauri ! 
	 * return the alternate id of the term if present. Null per default. 
	 */
	public String getAlternateId();

	/**
	 * Set the alternate name of the term if present.
	 * E.g. in SNS, ONE term can have different names from different thesauri ! 
	 * @param alternateName the alternate name of the term. Null per default. 
	 */
	public void setAlternateName(String alternateName);

	/**
	 * Get the alternate name of the term if present.
	 * E.g. in SNS, ONE term can have different names from different thesauri ! 
	 * return the alternate name of the term if present. Null per default. 
	 */
	public String getAlternateName();
}
