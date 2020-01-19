package org.wahlzeit.model;

public class Landscape {
	private LandscapeType type;
	private int id;
	
	public Landscape(int id, LandscapeType type) {
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}
	
	public LandscapeType getType() {
		return type;
	}
	
	public void setType(LandscapeType type) {
		this.type = type;
	}
}
