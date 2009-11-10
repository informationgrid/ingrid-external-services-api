/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Basic semantic unit of a Gazetteer.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>id</code>: arbitrary unique identifier of the location in the gazetteer 
 * <li><code>name</code>: the name of the location
 * </ul>
  * NOTICE: dependent from the context further data could be provided.
 * E.g. if location is a result of a full classification of a text or URL (see 
 * FullClassifyService) then as much data as possible should be provided.
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
	 * Set the bounding box of the location in WGS84 coordinates.
	 * @param bottomLeftLong lower left longitude in WGS84
	 * @param bottomLeftLat lower left latitude in WGS84
	 * @param upperRightLong upper right longitude in WGS84
	 * @param upperRightLat upper right latitude in WGS84
	 */
	public void setBoundingBox(float bottomLeftLong, float bottomLeftLat, float upperRightLong, float upperRightLat);
	
	/**
	 * Get the bounding box of the location in WGS84 coordinates.
	 * @return the bounding box as array of WGS84 coordinates [lower left longitude, lower left latitude,
	 * 	upper right longitude, upper right latitude] or NULL if not set
	 */
	public float[] getBoundingBox();

	/**
	 * Set the type id of the location, e.g. when using SNS
	 * this is an identifier indicating a Nature Park ("naturalParkType") or Federal State ("use2Type") ...
	 * @param typeId the id of the type of the location (utilized in SNS) 
     * @see setTypeName
	 */
	public void setTypeId(String typeId);

	/**
	 * Get the type id of the location, e.g. when using SNS
	 * this is an identifier indicating a Nature Park ("naturalParkType") or Federal State ("use2Type") ...
	 * @return the id of the type of the location (utilized in SNS) or NULL
     * @see getTypeName
	 */
	public String getTypeId();

	/**
	 * Set the according name of the type of the location, e.g. when using SNS
	 * this is "Nature Park" (for type id "naturalParkType") or "Federal State" (for type id "use2Type") ...
	 * @param typeName the according name of the type id of the location (utilized in SNS)
     * @see setTypeId
	 */
	public void setTypeName(String typeName);

	/**
	 * Get the according name of the type of the location, e.g. when using SNS
	 * this is "Nature Park" (for type id "naturalParkType") or "Federal State" (for type id "use2Type") ...
	 * @return the according name of the type id of the location (utilized in SNS) or NULL
     * @see getTypeId
	 */
	public String getTypeName();

	/**
	 * Set the additional qualifier of the location, e.g. name affix.
	 * @param qualifier additional qualifier of location
	 */
	public void setQualifier(String qualifier);

	/**
	 * Get the additional qualifier of the location, e.g. name affix.
	 * @return additional qualifier of location or NULL
	 */
	public String getQualifier();

	/**
	 * Set the native key of the location, e.g. when using SNS
	 * this is a "regional key" (RS) or "commune key" (AGS).
	 * @param nativeKey defined code of the location
	 */
	public void setNativeKey(String nativeKey);

	/**
	 * Get the native key of the location, e.g. when using SNS
	 * this is a "regional key" (RS) or "commune key" (AGS).
	 * @return defined code of the location or NULL
	 */
	public String getNativeKey();
}
