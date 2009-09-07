/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.RelatedTerm;
import de.ingrid.external.om.Term;
import de.ingrid.external.om.TreeTerm;


/**
 * Abstract interface (API) for accessing thesaurus.
 * The semantic unit of the thesaurus is a <code>Term</code> encapsulating all term data.
 * Further context specific data is encapsulated in a <code>RelatedTerm</code> or <code>TreeTerm</code>.
 */
public interface ThesaurusService {

    /**
     * Get related names of terms for a given arbitrary name.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/main-search.psml?action=doSearch&q=water
     * <br/>Klick "Similar Terms: Search for ..."
     * @param name arbitrary name to search related names of terms for.
     * @param language which language, pass null if default language
     * @return Array of related names (or empty array)
     */
    String[] getRelatedNamesFromName(String name, Locale language);

    /**
     * Classify a text meaning get thesaurus terms describing the text.
     * When using SNS the autoclassify method of SNS is used.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text and click "Thesaurus look-up"
     * Further used when search index (web sites etc.) is enriched with thesaurus data.
     * @param text The text to classify. Multiple words, sentences etc.
     * @param language which language, pass null if default language
     * @return Array of thesaurus terms found for text (or empty array)
     */
    Term[] getTermsFromText(String text, Locale language);

    /**
     * Get all related terms for a given term.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text, click "Thesaurus look-up" and click on found term
     * @param termId the unique identifier of the source term in thesaurus
     * @param language which language, pass null if default language
     * @return Array of related terms found for passed term (or empty array)
     */
    RelatedTerm[] getRelatedTermsFromTerm(String termId, Locale language);

    /**
     * Get term with given id.<br/>
     * PortalU: Used for getting detailed term data, e.g. when term is clicked in extended search browser
     * @param termId the unique identifier of the term in thesaurus
     * @param language which language, pass null if default language
     * @return the found term or null if not found
     */
    Term getTerm(String termId, Locale language);

    /**
     * Get all child terms of the given term in next level. Used for browsing tree structure.
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-catalog/search-catalog-thesaurus.psml
     * @param termId the unique identifier of the term to fetch subterms from. PASS NULL IF TOP TERMS WANTED !
     * @param language which language, pass null if default language
     * @return Array containing next level of terms (or empty array)
     */
    TreeTerm[] getHierarchyNextLevel(String termId, Locale language);

    /**
     * Get the path of terms to the top starting at term with given id.
     * PortalU: used in IGE (InGridEditor) to show term in tree (open all parent nodes)
     * @param termId the unique identifier of the term to determine parents.
     * @param language which language, pass null if default language
     * @return Array containing parent terms starting with term with given id.
     *  index0=term with given id, index1=parent, index2=parent of parent, ... top node
     */
    TreeTerm[] getHierarchyPathToTop(String termId, Locale language);
}
