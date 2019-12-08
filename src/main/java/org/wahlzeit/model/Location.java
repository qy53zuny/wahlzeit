package org.wahlzeit.model;

public class Location {
	
	
	private String name;
	private Coordinate coordinate;
	
	public Location() {
		this.name = "";
		this.coordinate = new CartesianCoordinate();
	}

	public Location(String name) {
		this.name = name;
		this.coordinate = new CartesianCoordinate();
	}
	
	public Location(Coordinate coordinate) throws IllegalArgumentException {
		this.name = "";
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		this.coordinate = coordinate;
	}
	
	public Location(Coordinate coordinate, String name) throws IllegalArgumentException {
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
