/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2024 wemove digital solutions GmbH
 * ==================================================
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 * 
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 * 
 * https://joinup.ec.europa.eu/software/page/eupl
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 * **************************************************#
 */
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
