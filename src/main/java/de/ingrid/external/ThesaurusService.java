/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.RelatedTerm;
import de.ingrid.external.om.Term;


/**
 * Abstract interface (API) for accessing thesaurus.
 * A semantic unit of the thesaurus is encapsulated in a <code>Term</code>.
 */
public interface ThesaurusService {

    /**
     * Get related names for a given name.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/main-search.psml?action=doSearch&q=water
     * <br/>Klick "Similar Terms: Search for ..."
     * @param name The given name to search related names for.
     * @param language which language, pass null if default language
     * @return Array of related names
     */
    String[] getRelatedNamesFromName(String name, Locale language);

    /**
     * Get all related terms for a given term.<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text, click "Thesaurus look-up" and click on found term
     * @param termId the unique identifier of the source term
     * @param language which language, pass null if default language
     * @return Array of related terms found for passed term
     */
    RelatedTerm[] getRelatedTermsFromTerm(String termId, Locale language);

    /**
     * Classify a text meaning get thesaurus terms describing the text.
     * When using SNS the autoclassify method of SNS is used.
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text and click "Thesaurus look-up"
     * @param text The text to classify. Multiple words, sentences etc.
     * @param language which language, pass null if default language
     * @return Array of thesaurus terms found for text.
     */
    Term[] getTermsFromText(String text, Locale language);
}
