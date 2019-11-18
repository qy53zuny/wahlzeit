package org.wahlzeit.model;

public class SphericCoordinate implements Coordinate {
	
	private double phi;
	private double theta;
	private double radius;
	
	public SphericCoordinate() {
		setCoordinate(0,0,0);
	}

	public SphericCoordinate(double phi, double theta, double radius) {
		setCoordinate(phi, theta, radius);
	}
	
	public SphericCoordinate(Coordinate coord) {
		SphericCoordinate c = coord.asSphericCoordinate();
		setCoordinate(c.phi, c.theta, c.radius);
	}
	
	public void setCoordinate(double phi, double theta, double radius) {
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		double x = radius*Math.cos(phi)*Math.sin(theta);
		double y = radius*Math.sin(phi)*Math.sin(theta);
		double z = radius*Math.cos(theta);
		
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		return this;
	}

	@Override
	public double getCartesianDistance(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		return this.asCartesianCoordinate().getCartesianDistance(coordinate);
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		SphericCoordinate c = coordinate.asSphericCoordinate();
		double phiDif = Math.abs(phi-c.phi);
		double thetaDif = Math.abs(theta-c.theta);
		double res = Math.sin(thetaDif/2);
		res = res*res*Math.cos(phi)*Math.cos(c.phi) + Math.pow(Math.sin(phiDif/2), 2);
		res = 2*Math.asin(Math.sqrt(res));
		return res;
	}

	@Override
	public boolean isEqual(Coordinate coordinate) {
		
		return this.asCartesianCoordinate().isEqual(coordinate);
	}
	
	@Override
	public boolean equals(Object o) {
		return this.asCartesianCoordinate().equals(o);
	}
	
	@Override
	public int hashCode() {
		final int prime = 41;
		int result = 1;
		result = prime*result + Double.hashCode(phi);
		result = prime*result + Double.hashCode(theta);
		result = prime*result + Double.hashCode(radius);
		
		return result;
		
	}

}
