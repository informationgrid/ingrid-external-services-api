/*
 * **************************************************-
 * ingrid-external-services-api
 * ==================================================
 * Copyright (C) 2014 - 2015 wemove digital solutions GmbH
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
package de.ingrid.external.om.impl;

import de.ingrid.external.om.Location;

/**
 * Default Implementation of Location Interface.
 */
public class LocationImpl implements Location {

	private String id;
	private String typeId;	 // e.g. for SNS: use2Type, naturalParkType, ... 
	private String typeName; // e.g. for SNS: "Federal State", "Nature Park", ... 
	private String name;
	private String qualifier;
	private String nativeKey;
	private boolean isExpired = false;
	private String expiredDate;
	private String[] successorIds;
	
	// The coordinates are stored as:
	// 		lower left corner longitude, lower left corner latitude, 
	// 		upper right corner longitude, upper right corner latitude 
	public float[] boundingBox;

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getTypeId() {
		return typeId;
	}

	@Override
	public String getTypeName() {
		return typeName;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getQualifier() {
		return qualifier;
	}

	@Override
	public float[] getBoundingBox() {
		return boundingBox;
	}

	@Override
	public String getNativeKey() {
		return nativeKey;
	}

	@Override
	public boolean getIsExpired() {
		return isExpired;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	@Override
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setQualifier(String qualifier) {
		this.qualifier = qualifier;
	}

	public void setBoundingBox(float[] boundingBox) {
		this.boundingBox = boundingBox;
	}

	@Override
	public void setBoundingBox(float bottomLeftLong, float bottomLeftLat, float upperRightLong, float upperRightLat) {
		this.boundingBox = new float[4];
		this.boundingBox[0] = bottomLeftLong;
		this.boundingBox[1] = bottomLeftLat;
		this.boundingBox[2] = upperRightLong;
		this.boundingBox[3] = upperRightLat;
	}

	@Override
	public void setNativeKey(String nativeKey) {
		this.nativeKey = nativeKey;
	}

	@Override
	public void setIsExpired(boolean isExpired) {
		this.isExpired = isExpired;
	}

	public String toString() {
		String result = "[";
		result += "ID: "+this.id;
		result += ", Name: "+this.name;
		result += ", Type ID: "+this.typeId;
		result += ", Type Name: "+this.typeName;
		result += ", Qualifier: "+this.qualifier;
		result += ", Native Key: "+this.nativeKey;
		result += ", Expired: "+this.isExpired;
		if (this.boundingBox != null && this.boundingBox.length == 4) {
			result += ", WGS84Box: "+this.boundingBox[0]+","+this.boundingBox[1]+" "+this.boundingBox[2]+","+this.boundingBox[3];
		}
		result += "]";
		return result;
	}
	
	@Override
	public String[] getSuccessorIds() {
	    return this.successorIds;
	}
	
	@Override
	public void setSuccessorIds(String[] ids) {
	    this.successorIds = ids;
	}

	@Override
    public String getExpiredDate() {
        return expiredDate;
    }

	@Override
    public void setExpiredDate( String expiredDate ) {
        this.expiredDate = expiredDate;
    }
}
