package org.wahlzeit.model;

import static org.junit.Assert.assertTrue;

public class SphericCoordinate extends AbstractCoordinate {
	
	private double phi;
	private double theta;
	private double radius;
	
	public double getPhi() {
		assertClassInvariants();
		return phi;
	}
	
	public void setPhi(double phi) {
		assertClassInvariants();
		assertPhiValid(phi);
		this.phi = phi;
		assertClassInvariants();
	}
	
	public double getTheta() {
		assertClassInvariants();
		return theta;
	}
	
	public void setTheta(double theta) {
		assertClassInvariants();
		assertThetaValid(theta);
		this.theta = theta;
		assertClassInvariants();
	}
	
	public double getRadius() {
		assertClassInvariants();
		return radius;
	}
	
	public void setRadius(double radius) {
		assertClassInvariants();
		assertRadiusValid(radius);
		this.radius = radius;
		assertClassInvariants();
	}
	
	
	public SphericCoordinate() {
		setCoordinate(0,0,0);
		assertClassInvariants();
	}

	public SphericCoordinate(double phi, double theta, double radius) {
		assertPhiValid(phi);
		assertThetaValid(theta);
		assertRadiusValid(radius);
		
		setCoordinate(phi, theta, radius);
		assertClassInvariants();
	}
	
	public SphericCoordinate(Coordinate coord) {
		SphericCoordinate c = coord.asSphericCoordinate();
		setCoordinate(c.phi, c.theta, c.radius);
	}
	
	public void setCoordinate(double phi, double theta, double radius) {	
		assertPhiValid(phi);
		assertThetaValid(theta);
		assertRadiusValid(radius);
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		
		assertClassInvariants();
		
		double x = radius*Math.cos(phi)*Math.sin(theta);
		double y = radius*Math.sin(phi)*Math.sin(theta);
		double z = radius*Math.cos(theta);
		
		assertFinite(x);
		assertFinite(y);
		assertFinite(z);
		
		assertClassInvariants();
		
		return new CartesianCoordinate(x,y,z);
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		return this;
	}
	
	@Override
	public boolean equals(Object o) {
		return this.asCartesianCoordinate().equals(o);
	}
	
	@Override
	public int hashCode() {
		assertClassInvariants();
		
		final int prime = 41;
		int result = 1;
		result = prime*result + Double.hashCode(phi);
		result = prime*result + Double.hashCode(theta);
		result = prime*result + Double.hashCode(radius);
		
		assertClassInvariants();
		return result;
		
	}
	
	
	protected static void assertThetaValid(Double theta) {
		assertValidAngle(theta);
	}
	
	protected static void assertPhiValid(Double phi) {
		assertValidAngle(phi);
		assertTrue(phi<=Math.PI);
	}
	
	protected static void assertRadiusValid(Double r) {
		assertFinite(r);
		assertNotNan(r);
		assertNonNegative(r);
	}

	@Override
	protected void assertClassInvariants() {
		assertThetaValid(this.theta);
		assertPhiValid(this.phi);
		assertRadiusValid(this.radius);
	}
	
}
