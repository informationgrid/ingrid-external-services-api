/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;


import java.util.Locale;

import de.ingrid.external.om.RelatedTerm;
import de.ingrid.external.om.Term;
import de.ingrid.external.om.TreeTerm;


/**
 * Interface (API) for accessing thesaurus.<p>
 * The basic semantic unit of the thesaurus is a <code>Term</code> encapsulating basic information of the term like name, id etc.
 * Further context specific data is encapsulated in a <code>RelatedTerm</code> or <code>TreeTerm</code>.
 */
public interface ThesaurusService {

    /**
     * Get similar thesaurus terms for arbitrary names (words). This is used for
     * a better word choice for searching. Normally it is used for a single name,
     * but SNS also supports fetching of similar terms for multiple names in one call,
     * so we support this here !</br>
     * NOTICE: The returned terms are <b>ordered alphabetically</b>!
     * If multiple names are passed the reference between the returned terms and
     * the input names is lost.
     * <ul><li>PortalU: http://www.portalu.de/ingrid-portal/portal/main-search.psml?action=doSearch&q=water
     * <br/>Klick "Similar Terms: Search for ..."
     * </ul>
     * @param names arbitrary names (words) to search similar thesaurus terms for.
     * @param language should the search be case sensitive (false) or ignore case (true)
     * @param language language of the names and the results.
     * @return Array of similar thesaurus terms (or empty array).
     * NOTICE: The terms are <b>ordered alphabetically, no duplicates</b>!
     * The Terms can be of arbitrary type (DESCRIPTOR, NON_DESCRIPTOR).
     */
	Term[] getSimilarTermsFromNames(String[] names, boolean ignoreCase, Locale language);

    /**
     * Classify a text meaning identify thesaurus <b>DESCRIPTOR</b> terms describing the text.
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul><li>used in Portal Extended Search for look up of thesaurus terms from arbitrary
     * entered text see<br/>
     * PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text and click "Thesaurus look-up"
     * </ul>
     * @param text any kind of text to classify
     * @param analyzeMaxWords The maximal number of words to analyze.
     * 		if the document contains more words these will be ignored
     * @param ignoreCase Set to true to ignore capitalization of the text
     * @param language language of the text and the results.
     * @return Array of thesaurus <b>DESCRIPTOR</b> terms found for text (or empty array)
     */
    Term[] getTermsFromText(String text, int analyzeMaxWords, boolean ignoreCase, Locale language);

    /**
     * Get all related terms for a given term.<br/>
     * <ul><li>PortalU: http://www.portalu.de/ingrid-portal/portal/search-extended/search-ext-env-topic-thesaurus.psml
     * <br/>Enter text, click "Thesaurus look-up" and click on found term
     * </ul>
     * @param termId the unique identifier of the term to found related terms from
     * @param language which language
     * @return Array of related terms for passed term (or empty array)
     */
    RelatedTerm[] getRelatedTermsFromTerm(String termId, Locale language);

    /**
     * Get term with given id.<br/>
     * <ul><li>PortalU: Used for getting detailed term data, e.g. when term is clicked in term browser in extended search.
     * </ul>
     * @param termId the unique identifier of the term in thesaurus
     * @param language which language to fetch
     * 	NOTICE: may be ignored by service if termId already determines language !
     * @return the found term or null if not found
     */
    Term getTerm(String termId, Locale language);

    /**
     * Get all direct child terms of the given term in an Array (next hierarchy level). Pass null to request top terms.
     * Used for browsing tree structure. NOTICE: Returned terms in array contain Term with given id as parent
     * (OR null if top terms). Further the terms in the array contain their children, so 2 hierarchy
     * levels are fetched. <b>See <code>TreeTerm</code></b> 
     * <ul><li>PortalU: http://www.portalu.de/ingrid-portal/portal/search-catalog/search-catalog-thesaurus.psml
     * </ul>
     * @param termId the unique identifier of the term to fetch subterms from. PASS NULL IF TOP TERMS WANTED !
     * @param language which language
     * @return Array containing next level of terms (or empty array if leaf). The terms contain their parent and
     * their children.
     */
    TreeTerm[] getHierarchyNextLevel(String termId, Locale language);

    /**
     * Get the paths to the top in hierarchy starting at term with given id. NOTICE: A
     * term can have multiple parents, so ALL paths to the top should be determined.
     * Used for searching term in a tree. The TreeTerm with the passed id is returned
     * containing all of its parent(s). <b>See <code>TreeTerm</code></b>
     * <ul><li>PortalU: used in IGE (InGridEditor) to search term in tree
     * </ul>
     * @param termId the unique identifier of the term to determine parents from.
     * @param language which language
     * @return The starting term with the given id containing all of its parent(s). These parent(s)
     * contain their parent(s) as well till top.
     */
    TreeTerm getHierarchyPathToTop(String termId, Locale language);
}
