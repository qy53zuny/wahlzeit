package org.wahlzeit.model;

import static org.junit.Assert.*;

public abstract class AbstractCoordinate implements Coordinate {

	private static final double EPSILON = 0.001;
	
	@Override
	protected Object clone() {
		return this;
	}
	
	public boolean equals(Object o) {
		return this == o;
	}
	
	@Override
	abstract public int hashCode();
	
	@Override
	public double getCartesianDistance(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException {
		
		assertClassInvariants();
		
		try {
			assertCoordinateNotNull(coordinate);
		}
		catch(NullPointerException e) {
			throw new IllegalArgumentException("the given coord Paramter is null: "+e.getMessage());
		}
		
		
		CartesianCoordinate thisCartesian = this.asCartesianCoordinate();
		CartesianCoordinate c = coordinate.asCartesianCoordinate();
		
		if(this.isEqual(c)) {
			return 0;
		}
		
		double result = Math.sqrt(Math.pow((c.getX()-thisCartesian.getX()),2) + Math.pow((c.getY()-thisCartesian.getY()),2) + Math.pow((c.getZ()-thisCartesian.getZ()),2));
		
		assertNotNan(result);
		assertFinite(result);
		assertNonNegative(result);
		
		assertClassInvariants();
		
		return result;
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) throws IllegalArgumentException, IllegalStateException {
		
		assertClassInvariants();
		
		try {
			assertCoordinateNotNull(coordinate);
		}
		catch(NullPointerException e) {
			throw new IllegalArgumentException("the given coordinate Paramter is null: "+e.getMessage());
		}
		
		SphericCoordinate thisSpheric = this.asSphericCoordinate();
		SphericCoordinate c = coordinate.asSphericCoordinate();
		
		double phiDif = Math.abs(thisSpheric.getPhi()-c.getPhi());
		double thetaDif = Math.abs(thisSpheric.getTheta()-c.getTheta());
		double res = Math.sin(thetaDif/2);
		res = res*res*Math.cos(thisSpheric.getPhi())*Math.cos(c.getPhi()) + Math.pow(Math.sin(phiDif/2), 2);
		res = 2*Math.asin(Math.sqrt(res));
		
		assertValidAngle(res);
		
		assertClassInvariants();
		return res;
	}

	@Override
	public boolean isEqual(Coordinate coord) {
		
		assertClassInvariants();
		
		if(coord==null) {
			return false;
		}
		
		CartesianCoordinate thisCartesian = this.asCartesianCoordinate();
		CartesianCoordinate c = coord.asCartesianCoordinate();		
		
		if((Math.abs(thisCartesian.getX()-c.getX()) < EPSILON) && (Math.abs(thisCartesian.getY()-c.getY()) < EPSILON) && (Math.abs(thisCartesian.getZ()-c.getZ()) < EPSILON)) {
			return true;
		}
		
		assertClassInvariants();
		return false;
	}
	
	protected static void assertCoordinateNotNull(Coordinate c) throws NullPointerException {
		if(c == null) {
			throw new NullPointerException("given Coordinate is null");
		}
	}
	
	protected static void assertNotNan(Double d) throws IllegalStateException{
		if(Double.isNaN(d)) {
			throw new IllegalStateException("double value is NaN");
		}
	}
	
	protected static void assertFinite(Double d) throws IllegalStateException{
		if(!Double.isFinite(d)) {
			throw new IllegalStateException("double value is infinite");
		}
	}
	
	protected static void assertNonNegative(Double d) throws IllegalStateException {
		if(!(d>=0)) {
			throw new IllegalStateException("double value is negative: "+d.toString());
		}
	}
	
	protected static void assertValidAngle(Double angle) throws IllegalStateException{
		assertNotNan(angle);
		assertFinite(angle);
		assertNonNegative(angle);
		if(!(angle<=2*Math.PI)) {
			throw new IllegalStateException("value of angle > 360°");
		}
	}
	
	protected abstract void assertClassInvariants();

}
