package org.wahlzeit.model;

public class Location {
	
	
	private String name;
	private Coordinate coordinate;
	
	public Location() {
		this.name = "";
		this.coordinate = new Coordinate();
	}

	public Location(String name) {
		this.name = name;
		this.coordinate = new Coordinate();
	}
	
	public Location(Coordinate coordinate) {
		this.name = "";
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		this.coordinate = coordinate;
	}
	
	public Location(Coordinate coordinate, String name) {
		this.name = name;
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		this.coordinate = coordinate;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}
	
	
}
