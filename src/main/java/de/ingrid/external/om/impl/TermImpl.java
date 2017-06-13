/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2017 wemove digital solutions GmbH
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
package de.ingrid.external.om.impl;

import java.util.List;

import de.ingrid.external.om.Term;

/**
 * Default Implementation of Term Interface.
 */
public class TermImpl implements Term {

    protected String id;
    protected String name;
    protected TermType type;
    /** SNS -> GEMET ID if present */
    protected String alternateId;
    /** SNS -> UMTHES name if different from GEMET name */
    protected String alternateName;
    protected List<String> inspireThemes;

    public TermImpl() {}

    public TermImpl(String id, String name, TermType type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

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
        result += "ID: " + this.id;
        result += ", Name: " + this.name;
        result += ", Type: " + this.type;
        result += ", alternateId: " + this.alternateId;
        result += ", alternateName: " + this.alternateName;
        if (this.inspireThemes != null && this.inspireThemes.size() > 0) {
            result += ", inspireThemes: " + this.inspireThemes;
        }
        result += "]";
        return result;
    }

    /**
     * Only compares id meaning two TermImpl are equal if they have same id !
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other == this)
            return true;
        if (!(other instanceof TermImpl))
            return false;
        TermImpl otherTermImpl = (TermImpl) other;
        if (this.getId() != null && this.getId().equals( otherTermImpl.getId() )) {
            return true;
        }
        return false;
    }
}
