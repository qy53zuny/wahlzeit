package org.wahlzeit.model;

public class Coordinate {
	
	private double x,y,z;
	
	public Coordinate() {
		setCoordinate(0.0, 0.0, 0.0);
	}
	
	public Coordinate(double x, double y, double z) {
		setCoordinate(x,y,z);
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public boolean isEqual(Coordinate c) {
		
		if(c==null) {
			return false;
		}
		
		if((this.x == c.x) && (this.y == c.y) && (this.z == c.z)) {
			return true;
		}
		
		return false;
	}
	
	public double getDistance(Coordinate c) {
		
		if(c == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		if(this.isEqual(c)) {
			return 0;
		}
		
		return Math.sqrt(Math.pow((c.x-this.x),2) + Math.pow((c.y-this.y),2) + Math.pow((c.z-this.z),2));
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(o == this) {
			return true;
		}
		
		if(!(o instanceof Coordinate)) {
			return false;
		}
		
		Coordinate c = (Coordinate) o;
		return isEqual(c);
	}
	
	
}
