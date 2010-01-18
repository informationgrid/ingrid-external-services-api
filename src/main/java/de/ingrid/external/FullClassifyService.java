/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import java.net.URL;
import java.util.Locale;

import de.ingrid.external.om.FullClassifyResult;


/**
 * Service used for extracting "full" data (e.g. meta data like terms, locations, ...) from document/URL.
 */
public interface FullClassifyService {

	/** How should the text be classified ? Extract all infos possible or only partial infos ?
	 * This FilterType determines which partial info to extract. */
	public enum FilterType {
		/** request only terms (ThesaurusService) as result of classification */
		ONLY_TERMS,
		/** request only locations (GazetteerService) as result of classification */
		ONLY_LOCATIONS,
		/** request only events (time information) as result of classification */
		ONLY_EVENTS;
	}

    /**
     * Analyze the given URL. Extract terms, locations, events (time information).
     * This data is used for indexing web sites, meaning added as metadata to the index.
     * E.g. classified locations BBox/nativeKey information may be added
     * as metadata to the index.</br>
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul>
     * <li>used in Metadata-Editor when new metadata record is created via
     * the wizard. There a URL can be entered, the API is called and the wizard
     * shows the results as suggestion for the content of the new record
     * <li>used in iPlug when indexing content (e.g. webpages) to enrich the
     * index with thesaurus, gazetteer, time information etc. Then this additional data
     * can be queried from the Portal (e.g. when searching for a thesaurus term)
     * delivering the according content (e.g. the webpage)
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_autoclassifyurl.html?lang=en
     * </ul>
     * @param url The url to analyze.
     * @param analyzeMaxWords The maximal number of words to analyze (body)
     * @param ignoreCase Set to true ignore capitalization of the document.
     * @param filter Pass null to extract all infos possible ? If only partial data
     * 		should be extracted pass according filter type.
     * @param lang language of the web page and the results.
     * @return result containing info about the document and the classified terms,
     * 		locations and events dependent from passed filter type. NEVER NULL.
     */
    public FullClassifyResult autoClassifyURL(URL url, int analyzeMaxWords, boolean ignoreCase,
    		FilterType filter, Locale language);
}
