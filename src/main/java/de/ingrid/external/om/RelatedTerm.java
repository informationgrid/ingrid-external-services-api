/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2023 wemove digital solutions GmbH
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

/**
 * Representation of a thesaurus term related to another thesaurus term.
 * Adds additional information about the relation.<p>
 * Mandatory content (NOT NULL):
 * <ul><li>see <code>Term</code>
 * <li><code>relationType</code>: the type of the relation.
 * </ul>
 */
public interface RelatedTerm extends Term {
	
	/** Type of the relation of <code>this</code> term to another term. */
	public enum RelationType {
		/** term is a parent */
		PARENT,
		/** term is a child */
		CHILD,
		/** term is somehow connected (e.g. is a synonym when utilizing SNS) */
		RELATIVE;
	}

	/**
	 * Set the type of the relation of <code>this</code> term to another term.
	 * @param type type of relation of <code>this</code> term, NOT NULL
	 */
	public void setRelationType(RelationType type);

	/**
	 * Get the type of the relation of <code>this</code> term to another term.
	 * @return type of relation of <code>this</code> term, NOT NULL
	 */
	public RelationType getRelationType();
}
