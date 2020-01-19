package org.wahlzeit.model;

import java.util.ArrayList;
import java.util.List;

public class LandscapeType {
	private String name;
	protected LandscapeType superType;
	protected List<LandscapeType> subtypes = new ArrayList<LandscapeType>();
	
	public LandscapeType(String name) {
		this.name = name;
		this.superType = this;
	}
	
	public LandscapeType(String name, LandscapeType superType) {
		this.name = name;
		this.superType = superType;
	}
	
	public Landscape createInstance(int id) {
		return new Landscape(id, this);
	}
	
	public String getName() {
		return name;
	}
	
	public LandscapeType getSuperType() {
		return superType;
	}
	
	public List<LandscapeType> getSubtypes() {
		return subtypes;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSupertype(LandscapeType superType) {
		this.superType = superType;
	}
	
	public void addSubtype(LandscapeType subtype) {
		this.subtypes.add(subtype);
	}
	
	public boolean isSubtype() {
		if(!this.superType.equals(this)) {
			return true;
		}
		return false;
	}
}
