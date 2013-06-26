package de.ingrid.external.om.impl;

import de.ingrid.external.om.Link;

public class LinkImpl implements Link {
	
	private String link;
	
	private String title;

	@Override
	public String getLinkAddress() {
		return link;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public void setLinkAddress(String address) {
		this.link = address;		
	}

	@Override
	public void setTitle(String title) {
		this.title = title;
	}

}
