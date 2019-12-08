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
	
	public void setPhi(double phi) throws IllegalArgumentException {
		assertClassInvariants();
		try {
			assertPhiValid(phi);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("given paramter phi is not valid: "+e.getMessage());
		}
		
		this.phi = phi;
		assertClassInvariants();
	}
	
	public double getTheta() {
		assertClassInvariants();
		return theta;
	}
	
	public void setTheta(double theta)  throws IllegalArgumentException {
		assertClassInvariants();
		
		try {
			assertThetaValid(theta);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("given paramter theta is not valid: "+e.getMessage());
		}
		
		this.theta = theta;
		assertClassInvariants();
	}
	
	public double getRadius() {
		assertClassInvariants();
		return radius;
	}
	
	public void setRadius(double radius)  throws IllegalArgumentException {
		assertClassInvariants();
		
		try {
			assertRadiusValid(radius);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("given paramter radius is not valid: "+e.getMessage());
		}
		
		this.radius = radius;
		assertClassInvariants();
	}
	
	
	public SphericCoordinate() {
		setCoordinate(0,0,0);
		assertClassInvariants();
	}

	public SphericCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {
		try {
			assertPhiValid(phi);
			assertThetaValid(theta);
			assertRadiusValid(radius);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("a given parameter is not valid: "+e.getMessage());
		}
		
		setCoordinate(phi, theta, radius);
		assertClassInvariants();
	}
	
	public SphericCoordinate(Coordinate coord) {
		SphericCoordinate c = coord.asSphericCoordinate();
		setCoordinate(c.phi, c.theta, c.radius);
	}
	
	public void setCoordinate(double phi, double theta, double radius) throws IllegalArgumentException {	
		try {
			assertPhiValid(phi);
			assertThetaValid(theta);
			assertRadiusValid(radius);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("a given parameter is not valid: "+e.getMessage());
		}
		
		this.phi = phi;
		this.theta = theta;
		this.radius = radius;
		assertClassInvariants();
	}
	
	@Override
	public CartesianCoordinate asCartesianCoordinate() throws IllegalStateException {
		
		assertClassInvariants();
		
		double x = radius*Math.cos(phi)*Math.sin(theta);
		double y = radius*Math.sin(phi)*Math.sin(theta);
		double z = radius*Math.cos(theta);
		
		CartesianCoordinate.assertValidCoordinateValue(x);
		CartesianCoordinate.assertValidCoordinateValue(y);
		CartesianCoordinate.assertValidCoordinateValue(z);
		
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
	
	
	protected static void assertThetaValid(Double theta) throws IllegalStateException {
		try {
			assertValidAngle(theta);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("theta is not a valid angle: "+e.getMessage());
		}
		
	}
	
	protected static void assertPhiValid(Double phi) throws IllegalStateException {
		try {
			assertValidAngle(phi);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("phi is not a valid angle: "+e.getMessage());
		}
		
		if(!(phi<=Math.PI)) {
			throw new IllegalStateException("phi has to be <= PI");
		}
	}
	
	protected static void assertRadiusValid(Double r) throws IllegalStateException {
		try {
			assertFinite(r);
			assertNotNan(r);
			assertNonNegative(r);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("radius has not a valid value: "+e.getMessage());
		}
	}

	@Override
	protected void assertClassInvariants() throws IllegalStateException {
		assertThetaValid(this.theta);
		assertPhiValid(this.phi);
		assertRadiusValid(this.radius);
	}
	
}
