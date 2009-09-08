/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import java.net.URL;
import java.util.Locale;

import de.ingrid.external.om.FullClassifyResult;


/**
 * Service used for extracting ALL POSSIBLE data (terms, locations, ...) from document or url.<p>
 */
public interface FullClassifyService {
	
    /**
     * Analyze the given URL. Extract terms, locations etc..
     * Used in the Metada-Editor when a new object is created for suggestion of contents !    
     * @param url The url to analyze.
     * @param analyzeMaxWords The maximal number of words to analyze (body)
     * @param ignoreCase Set to true ignore capitalization of the document.
     * @param lang Language distinction.
     * @return result containing all found terms, locations etc.
     */
    public FullClassifyResult autoClassifyURL(URL url, int analyzeMaxWords, boolean ignoreCase, Locale language);
}
