/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Representation of a Gazetteer location.<p>
 */
public interface Location {

	/**
	 * Set the id of the location. 
	 * @param id unique identifier of the location in the gazetteer
	 */
	public void setId(String id);

	/**
	 * Get the id of the location.
	 * @return the unique identifier of the location in the gazetteer
	 */
	public String getId();

	/**
	 * Set the name of the location.
	 * @param name the name of the location
	 */
	public void setName(String name);

	/**
	 * Get the name of the location.
	 * @return the name of the location
	 */
	public String getName();

	/**
	 * Set the type of the location.
	 * @param type type of location, e.g. when using SNS key for Community, Nature Park, Federal State ... 
	 */
	public void setType(String type);

	/**
	 * Get the type of the location.
	 * @return the type of the location, e.g. when using SNS key for Community, Nature Park, Federal State ...
	 */
	public String getType();

	/**
	 * Set the native key of the location.
	 * @param nativeKey defined code of the location, e.g. when using SNS "regional key" (RS) or "commune key" (AGS)  
	 */
	public void setNativeKey(String nativeKey);

	/**
	 * Get the native key of the location.
	 * @return nativeKey defined code of the location, e.g. when using SNS "regional key" (RS) or "commune key" (AGS)
	 */
	public String getNativeKey();
}
