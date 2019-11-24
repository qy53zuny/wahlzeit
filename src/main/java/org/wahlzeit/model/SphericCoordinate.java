package org.wahlzeit.model;

public class SphericCoordinate extends AbstractCoordinate {
	
	private double phi;
	private double theta;
	private double radius;
	
	public double getPhi() {
		return phi;
	}
	
	public void setPhi(double phi) {
		this.phi = phi;
	}
	
	public double getTheta() {
		return theta;
	}
	
	public void setTheta(double theta) {
		this.theta = theta;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	
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
