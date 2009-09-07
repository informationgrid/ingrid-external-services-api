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
	 * @param id unique identifier of the location in the gazetteer, NEVER NULL
	 */
	public void setId(String id);

	/**
	 * Get the id of the location.
	 * @return the unique identifier of the location in the gazetteer, NEVER NULL
	 */
	public String getId();

	/**
	 * Set the name of the location.
	 * @param name the name of the location, NEVER NULL
	 */
	public void setName(String name);

	/**
	 * Get the name of the location.
	 * @return the name of the location, NEVER NULL
	 */
	public String getName();

	/**
	 * Set the bounding box of the location in wgs84 coordinates.
	 * @param bottomLeftLong lower left longitude in wgs84
	 * @param bottomLeftLat lower left latitude in wgs84
	 * @param upperRightLong upper right longitude in wgs84
	 * @param upperRightLat upper right latitude in wgs84
	 */
	public void setBoundingBox(float bottomLeftLong, float bottomLeftLat, float upperRightLong, float upperRightLat);
	
	/**
	 * Get the bounding box of the location in wgs84 coordinates.
	 * @return the bbox as array of wgs84 coordinates [lower left longitude, lower left latitude,
	 * 	upper right longitude, upper right latitude] or null if not set
	 */
	public float[] getBoundingBox();


	// ------------- SNS specific ? ----------------- //

	/**
	 * Set the type of the location (key), e.g. when using SNS key for Community, Nature Park, Federal State ...
	 * @param type type of location (key)
	 */
	public void setType(String type);

	/**
	 * Get the type of the location (key), e.g. when using SNS key for Community, Nature Park, Federal State ...
	 * @return the type of the location (key) or null
	 */
	public String getType();

	/**
	 * Set the additional qualifier of the location, e.g. name affix.
	 * @param qualifier additional qualifier of location or null
	 */
	public void setQualifier(String qualifier);

	/**
	 * Get the additional qualifier of the location, e.g. name affix.
	 * @return additional qualifier of location or null
	 */
	public String getQualifier();

	/**
	 * Set the native key of the location, e.g. when using SNS "regional key" (RS) or "commune key" (AGS).
	 * @param nativeKey defined code of the location
	 */
	public void setNativeKey(String nativeKey);

	/**
	 * Get the native key of the location, e.g. when using SNS "regional key" (RS) or "commune key" (AGS).
	 * @return nativeKey defined code of the location or null
	 */
	public String getNativeKey();
}
