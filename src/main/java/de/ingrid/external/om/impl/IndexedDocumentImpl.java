package de.ingrid.external.om.impl;

import java.net.URL;
import java.util.Date;
import java.util.Locale;

import de.ingrid.external.om.IndexedDocument;

/**
 * Default Implementation of IndexedDocument Interface.
 */
public class IndexedDocumentImpl implements IndexedDocument {

	private Date classifyTimestamp;
	private String title;
	private String description;
	private Locale locale;
	private Date timeAt;
	private Date timeFrom;
	private Date timeTo;
	private URL url;

	@Override
	public Date getClassifyTimeStamp() {
		return classifyTimestamp;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Locale getLang() {
		return locale;
	}

	@Override
	public Date getTimeAt() {
		return timeAt;
	}

	@Override
	public Date getTimeFrom() {
		return timeFrom;
	}

	@Override
	public Date getTimeTo() {
		return timeTo;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public URL getURL() {
		return url;
	}

	@Override
	public void setClassifyTimeStamp(Date timeStamp) {
		this.classifyTimestamp = timeStamp;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public void setLang(Locale lang) {
		this.locale = lang;		
	}

	@Override
	public void setTimeAt(Date at) {
		this.timeAt = at;
	}

	@Override
	public void setTimeFrom(Date from) {
		this.timeFrom = from;
	}

	@Override
	public void setTimeTo(Date to) {
		this.timeTo = to;
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void setURL(URL url) {
		this.url = url;
	}

	public String toString() {
		String result = "[";
		result += "ClassifyTimestamp: " + this.classifyTimestamp;
		result += ", Locale: "+this.locale;
		result += ", Title: "+this.title;
		result += ", Description: "+this.description;
		if (this.timeAt != null) {
			result += ", TimeAt: "+this.timeAt;
		}
		if (this.timeFrom != null) {
			result += ", TimeFrom: "+this.timeFrom;
		}
		if (this.timeTo != null) {
			result += ", TimeTo: "+this.timeTo;
		}
		if (this.url != null) {
			result += ", Url: "+this.url;
		}
		result += "]";
		return result;
	}
}
