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
/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external;

import java.net.URL;
import java.util.Locale;

import de.ingrid.external.om.FullClassifyResult;


/**
 * Service used for extracting "full" data (meta data like terms, locations, events) from document/URL.
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
     * This data is used for indexing web sites and is added as metadata to the index.
     * E.g. from classified locations BBox/nativeKey information may be added.</br>
     * When using SNS the autoclassify method of SNS is used.<br/>
     * <ul>
     * <li>used in Metadata-Editor when new metadata record is created via
     * the wizard. There a URL can be entered and the wizard shows the results
     * of classification as suggestion for the content of the new record.
     * <li>used in iPlug when indexing content (e.g. webpages) to enrich the
     * index with thesaurus, gazetteer, time information. Then this additional data
     * can be queried from the Portal delivering the according content (webpage)
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_autoclassifyurl.html?lang=en
     * </ul>
     * @param url The url to analyze.
     * @param analyzeMaxWords NOT USED: The maximal number of words to analyze (body)
     * @param ignoreCase NOT USED: Set to true to ignore capitalization of the document.
     * @param filter Pass null to extract all information possible ? If only partial data
     * 		should be extracted pass according filter type.
     * @param language language of the web page and the results.
     * @return classification result containing general info about the document (IndexedDocument)
     * 		and the classified terms, locations and events dependent from passed filter type.
     * 		NEVER NULL.
     */
    public FullClassifyResult autoClassifyURL(URL url, int analyzeMaxWords, boolean ignoreCase,
    		FilterType filter, Locale language);

    /**
     * Analyze the given Text. Extract terms, locations, events (time information).
     * This is the same functionality as autoClassifyURL. Use this method if you already
     * have the document (text) to classify. NOTICE: When calling this method with the
     * according filter (ONLY_TERMS, ONLY_LOCATIONS) this matches the according call
     * to ThesaurusService.getTermsFromText or GazetteerService.getLocationsFromText !
     * <ul>
     * <li>used in iPlug when indexing content to enrich the index with thesaurus,
     * gazetteer, time information.
     * <li>when using SNS here's the method called: http://www.semantic-network.de/doc_autoclassifytext.html?lang=en
     * </ul>
     * @param text any kind of text to classify
     * @param analyzeMaxWords NOT USED: The maximal number of words to analyze
     * @param ignoreCase NOT USED: Set to true to ignore capitalization of the document.
     * @param filter Pass null to extract all infos possible ? If only partial data
     * 		should be extracted pass according filter type.</br>
     * 		NOTICE: When filtering TERMS or LOCATIONS the result equals
     * 		ThesaurusService.getTermsFromText / GazetteerService.getLocationsFromText
     * @param language language of the web page and the results.
     * @return result containing info about the document and the classified terms,
     * 		locations and events dependent from passed filter type. NEVER NULL.
     * 		NOTICE: The info about the document (IndexedDocument) in the result may only
     * 		contain partial stuff (no URL etc.) 
     */
    public FullClassifyResult autoClassifyText(String text, int analyzeMaxWords, boolean ignoreCase,
    		FilterType filter, Locale language);
}
