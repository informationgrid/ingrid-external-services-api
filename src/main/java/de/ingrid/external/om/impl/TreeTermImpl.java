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
package de.ingrid.external.om.impl;

import java.util.ArrayList;
import java.util.List;

import de.ingrid.external.om.TreeTerm;

/**
 * Default Implementation of TreeTerm Interface.
 */
public class TreeTermImpl extends TermImpl implements TreeTerm {

    protected List<TreeTerm> parents;
    protected List<TreeTerm> children;

    @Override
    public List<TreeTerm> getChildren() {
        return children;
    }

    @Override
    public void addChild(TreeTerm child) {
        if (children == null) {
            children = new ArrayList<TreeTerm>();
        }
        if (!this.children.contains( child )) {
            children.add( child );
        }
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
        if (!this.parents.contains( parent )) {
            parents.add( parent );
        }
    }

    public String toString() {
        String result = super.toString() + " ";
        result += "parents: " + ((this.parents != null) ? parents.size() : null);
        result += ", children: " + ((this.children != null) ? children.size() : null);

        return result;
    }
}
