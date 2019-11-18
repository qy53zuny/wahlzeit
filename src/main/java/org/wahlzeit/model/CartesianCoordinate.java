package org.wahlzeit.model;

public class CartesianCoordinate implements Coordinate {
	
	private double x,y,z;
	private static final double EPSILON = 0.1;
	
	public CartesianCoordinate() {
		setCoordinate(0.0, 0.0, 0.0);
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		setCoordinate(x,y,z);
	}
	
	public CartesianCoordinate(Coordinate coord) {
		CartesianCoordinate c = coord.asCartesianCoordinate();
		setCoordinate(c.x, c.y, c.z);
	}
	
	public void setCoordinate(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public boolean isEqual(Coordinate coord) {
		
		if(coord==null) {
			return false;
		}
		
		CartesianCoordinate c = coord.asCartesianCoordinate();		
		
		if((Math.abs(x-c.x) < EPSILON) && (Math.abs(y-c.y) < EPSILON) && (Math.abs(z-c.z) < EPSILON)) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public double getCartesianDistance(Coordinate coord) {
		
		if(coord == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		
		CartesianCoordinate c = coord.asCartesianCoordinate();
		
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
		
		CartesianCoordinate c = null;
		if(o instanceof CartesianCoordinate) {
			c = (CartesianCoordinate) o;
		}
		else {
			Coordinate cs = (Coordinate) o;
			c = cs.asCartesianCoordinate();
		}
		
		return isEqual(c);
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		double radius = Math.sqrt(x*x + y*y + z*z);
		double phi = Math.atan2(y, x);
		double theta = Math.acos(z/radius);
	
		return new SphericCoordinate(phi, theta, radius);
	}


	@Override
	public double getCentralAngle(Coordinate c) {
		return this.asSphericCoordinate().getCentralAngle(c);
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;
		result = prime*result + Double.hashCode(x);
		result = prime*result + Double.hashCode(y);
		result = prime*result + Double.hashCode(z);
		
		return result;
		
	}
	
	public void printCoords() {
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		System.out.println("z: "+z);
	}
	
	
}
