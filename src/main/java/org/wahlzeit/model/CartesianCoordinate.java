package org.wahlzeit.model;

import static org.junit.Assert.*;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	
	public double getX() {
		assertClassInvariants();
		return x;
	}

	public void setX(double x) {
		assertClassInvariants();
		assertValidValue(x);		
		this.x = x;
		assertClassInvariants();
	}

	public double getY() {
		assertClassInvariants();
		return y;
	}

	public void setY(double y) {
		assertClassInvariants();
		assertValidValue(y);		
		this.y = y;
		assertClassInvariants();
	}
	
	public double getZ() {
		assertClassInvariants();
		return y;
	}

	public void setZ(double z) {
		assertClassInvariants();
		assertValidValue(z);		
		this.z = z;
		assertClassInvariants();
	}
	
	public CartesianCoordinate() {
		setCoordinate(0.0, 0.0, 0.0);
		assertClassInvariants();
	}
	
	public CartesianCoordinate(double x, double y, double z) {
		setCoordinate(x,y,z);
		assertClassInvariants();
	}
	
	public CartesianCoordinate(Coordinate coord) {
		CartesianCoordinate c = coord.asCartesianCoordinate();
		setCoordinate(c.x, c.y, c.z);
		assertClassInvariants();
	}
	
	public void setCoordinate(double x, double y, double z) {
		assertClassInvariants();
		assertValidValue(x);
		assertValidValue(y);
		assertValidValue(z);
		
		this.x = x;
		this.y = y;
		this.z = z;
		assertClassInvariants();
	}
	
	@Override
	public boolean equals(Object o) {
		
		assertClassInvariants();
		
		
		if(o == this) {
			return true;
		}
		
		if(!(o instanceof Coordinate)) {
			assertClassInvariants();
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
		
		if(this.hashCode() == c.hashCode()) {
			assertClassInvariants();
			return isEqual(c);
		}
		
		assertClassInvariants();
		
		return false;
		
		
	}

	@Override
	public CartesianCoordinate asCartesianCoordinate() {
		assertClassInvariants();
		return this;
	}

	@Override
	public SphericCoordinate asSphericCoordinate() {
		assertClassInvariants();
		
		double radius = Math.sqrt(x*x + y*y + z*z);
		double phi = Math.atan2(y, x);
		double theta = Math.acos(z/radius);
	
		SphericCoordinate.assertPhiValid(phi);
		SphericCoordinate.assertThetaValid(theta);
		SphericCoordinate.assertRadiusValid(radius);
		
		assertClassInvariants();
		return new SphericCoordinate(phi, theta, radius);
	}

	
	@Override
	public int hashCode() {
		assertClassInvariants();
		final int prime = 41;
		int result = 1;
		result = prime*result + Double.hashCode(x);
		result = prime*result + Double.hashCode(y);
		result = prime*result + Double.hashCode(z);
		
		assertClassInvariants();
		return result;
		
	}
	
	public void printCoords() {
		assertClassInvariants();
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		System.out.println("z: "+z);
	}
	
	protected static void assertValidValue(Double val) {
		assertNotNan(val);
		assertFinite(val);
	}
	
	@Override
	protected void assertClassInvariants() {
		assertValidValue(this.x);
		assertValidValue(this.y);
		assertValidValue(this.z);
	}
	
}
