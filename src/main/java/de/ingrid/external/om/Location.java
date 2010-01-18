/*
 * Copyright (c) 2009 wemove digital solutions. All rights reserved.
 */
package de.ingrid.external.om;

/**
 * Basic semantic unit of a Gazetteer.<p>
 * Mandatory content (NOT NULL):
 * <ul><li><code>id</code>: arbitrary unique identifier of the location in the gazetteer 
 * <li><code>name</code>: the name of the location
 * <li><code>isExpired</code>: boolean value indicating whether the location is expired (utilized in SNS)
 * </ul>
 * Further data may be SNS specific and can be ignored if the data cannot be provided with
 * another Gazetteer (EGN), see javadoc of setters.</br>
 * Important data is BBox information or nativeKey (administrative code of location).
 * This one may be used in Extended Search and indexing of web sites. 
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
	 * Set the bounding box of the location in WGS84 coordinates. Provide whenever possible.
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
	 * Set the id of the type of the location (utilized in SNS). In SNS typeId is separated from typeName
	 * for further evaluation. If you do have a typeName (see below) you can also set it here. Otherwise
	 * do not set it. This typeName may be rendered additionally to the location name !
	 * E.g. in SNS this is an identifier indicating a Nature Park ("naturalParkType") or Federal State ("use2Type") ...
	 * @param typeId the id of the type of the location (utilized in SNS).
	 * 		Pass full name of type (typeName) if not using SNS.
     * @see setTypeName
	 */
	public void setTypeId(String typeId);

	/**
	 * Get the type id of the location (utilized in SNS). E.g. in SNS this is an identifier
	 * indicating a Nature Park ("naturalParkType") or Federal State ("use2Type") ...
	 * If not using SNS the typeId is the full name of the type of the location if set. 
	 * @return the id of the type of the location (utilized in SNS) or NULL
     * @see getTypeName
	 */
	public String getTypeId();

	/**
	 * Set the type of the location as name (utilized in SNS). E.g. in SNS this is "Nature Park"
	 * (for type id "naturalParkType") or "Federal State" (for type id "use2Type") ... 
	 * If not using SNS set here your according type of the location as name (if provided).
	 * Also set your typeName as typeId. This typeName may be rendered additionally to the location name !
	 * @param typeName type of the location e.g. "Federal State" or "Nature Park" ... (utilized in SNS)
     * @see setTypeId
	 */
	public void setTypeName(String typeName);

	/**
	 * Get the type of the location as name (utilized in SNS). E.g. when using SNS
	 * this is "Nature Park" (for type id "naturalParkType") or "Federal State" (for type id "use2Type") ...
	 * @return type of the location e.g. "Federal State" or "Nature Park" ... (utilized in SNS)
     * @see getTypeId
	 */
	public String getTypeName();

	/**
	 * Set an additional qualifier for homographs (utilized in SNS).
	 * E.g. this can be a name affix further clarifying the location name.
	 * Leave empty if not provided in Gazetteer.
	 * @param qualifier additional qualifier of location name (utilized in SNS)
	 */
	public void setQualifier(String qualifier);

	/**
	 * Get the additional qualifier of the location name, e.g. name affix.
	 * @return additional qualifier of location name (utilized in SNS) or NULL
	 */
	public String getQualifier();

	/**
	 * Set the native key of the location (utilized in SNS). E.g. when using SNS
	 * this is a "regional key" (RS) or "commune key" (AGS). If you do have a standardized
	 * administrative code of the location provide it here. This code will be used when indexing
	 * web sites and can be added to the search via Extended Search (query field "areaid") !
	 * Otherwise leave it empty.
	 * @param nativeKey administrative code of the location (utilized in SNS)
	 */
	public void setNativeKey(String nativeKey);

	/**
	 * Get the native key of the location, e.g. when using SNS
	 * this is a "regional key" (RS) or "commune key" (AGS).
	 * @return administrative code of the location (utilized in SNS) or NULL
	 */
	public String getNativeKey();

	/**
	 * SNS knows "expired" locations. Set to true if the location is expired !
	 * @param isExpired set to true if location is expired. DEFAULT is false ! (utilized in SNS)
	 */
	public void setIsExpired(boolean isExpired);

	/**
	 * SNS knows "expired" locations. Set to true if the location is expired !
	 * @return true if location is expired. DEFAULT is false (not expired)(utilized in SNS)
	 */
	public boolean getIsExpired();
}
