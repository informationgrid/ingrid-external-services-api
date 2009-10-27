/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import java.net.URL;
import java.util.Locale;

import de.ingrid.external.om.FullClassifyResult;


/**
 * Service used for extracting ARBITRARY describing data (meta data like terms, locations, ...) from document or URL.<p>
 */
public interface FullClassifyService {
	
    /**
     * Analyze the given URL. Extract terms, locations etc.
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul><li>used in Metadata-Editor when new metadata record is created via
     * the wizard. There a URL can be entered, the API is called and the wizard
     * shows the results as suggestion for the content of the new record
     * <li>used in iPlug when indexing content (e.g. webpages) to enrich the
     * index with thesaurus, gazeteer, time information etc. Then this additional data
     * can be queried from the Portal (e.g. when searching for a thesaurus term)
     * delivering the according content (e.g. the webpage)
     * </ul>
     * @param url The url to analyze.
     * @param analyzeMaxWords The maximal number of words to analyze (body)
     * @param ignoreCase Set to true ignore capitalization of the document.
     * @param lang language of the web page and the results. If passed language can't be processed
     * 		or is null then default language may be used (PortalU: de, GS Soil: en)
     * @return result containing all classified terms, locations etc.
     * 	NOTICE: as much data as possible should be provided, e.g. locations should have
     * 	bounding box where possible ! 
     */
    public FullClassifyResult autoClassifyURL(URL url, int analyzeMaxWords, boolean ignoreCase, Locale language);
}
