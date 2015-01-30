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
 * Basic semantic unit of a Thesaurus.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>id</code>: arbitrary unique identifier of the term in the thesaurus 
 * <li><code>type</code>: the type of the term.
 * <li><code>name</code>: the name of the term
 * </ul>
 */
public interface Term {

	/** Type of the term. */
	public enum TermType {
		/** the term is a fully qualified term and can be used as a describing
		 * term in meta data. The standard ! */
		DESCRIPTOR,
		/** the term is just a synonym for another DESCRIPTOR term and should not be used
		 * as a describing term in meta data (utilized in SNS) */
		NON_DESCRIPTOR,
		/** the term is just a label (group or supergroup) in the hierarchy and should not be used
		 * as a describing term in meta data */
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
	 * Set the id of the term. NOTICE: SHOULD NOT EXCEED LENGTH OF 255 !
	 * @param id unique identifier of the term in the thesaurus, NEVER NULL
	 */
	public void setId(String id);

	/**
	 * Get the id of the term. NOTICE: SHOULD NOT EXCEED LENGTH OF 255 !
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
	 * Set the alternate id of the term if present.<br/>
	 * Utilized in SNS where ONE term can have different ids dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the numeric GEMET id if term has a GEMET representation.
	 * If this one is null, the term isn't handled as GEMET Term in InGrid !
	 * @param alternateId the alternate id of the term. SET HERE NUMERIC GEMET ID IF PRESENT ! 
	 */
	public void setAlternateId(String alternateId);

	/**
	 * Get the alternate id of the term if present.<br/>
	 * Utilized in SNS where ONE term can have different ids dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the numeric GEMET id if term has a GEMET representation.
	 * If this one is null, the term isn't handled as GEMET Term in InGrid !
	 * @return the alternate id of the term if present. THIS IS THE GEMET ID IF PRESENT. NULL per default (then no GEMET term). 
	 */
	public String getAlternateId();

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Set the alternate name of the term if present.<br/>
	 * Utilized in SNS where a term can have a different name dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the UMTHES name if term has a GEMET name.
	 * @param alternateName the alternate name of the term (utilized in SNS). NULL per default. 
	 */
	public void setAlternateName(String alternateName);

	/**
	 * SNS SPECIFIC, ALWAYS NULL IF NOT USING SNS (GSSoil) !</br>
	 * Get the alternate name of the term if present.<br/>
	 * Utilized in SNS where a term can have a different name dependent from used thesaurus (UMTHES, GEMET).
	 * This one holds the UMTHES name if term has a GEMET name.
	 * @return the alternate name of the term if present (utilized in SNS). NULL per default. 
	 */
	public String getAlternateName();

	/**
	 * Set a list of Inspire Themes the term is related to.</br>
	 * Used in IGE (Editor) to automatically add related inspire themes.
	 * @param inspireThemes list of inspire themes, e.g. "Addresses", "Administrative units",
	 * "Agricultural and aquaculture facilities" ... "Utility and governmental services".
	 */
	public void setInspireThemes(List<String> inspireThemes);

	/**
	 * Get a list of Inspire Themes the term is related to.</br>
	 * Used in IGE (Editor) to automatically add related inspire themes.
	 * @return list of inspire themes, e.g. "Addresses", "Administrative units",
	 * "Agricultural and aquaculture facilities" ... "Utility and governmental services".
	 * <b>NULL</b> per default
	 */
	public List<String> getInspireThemes();
}
