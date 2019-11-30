package org.wahlzeit.model;

import static org.junit.Assert.*;

public abstract class AbstractCoordinate implements Coordinate {

	private static final double EPSILON = 0.001;
	
	@Override
	public double getCartesianDistance(Coordinate coord) {
		
		assertClassInvariants();
		
		assertCoordinateNotNull(coord);
		
		CartesianCoordinate thisCartesian = this.asCartesianCoordinate();
		CartesianCoordinate c = coord.asCartesianCoordinate();
		
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
	public double getCentralAngle(Coordinate coordinate) {
		
		assertClassInvariants();
		
		assertCoordinateNotNull(coordinate);
		
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
	
	protected static void assertCoordinateNotNull(Coordinate c) {
		assertNotNull(c);
	}
	
	protected static void assertNotNan(Double d) {
		assertFalse(Double.isNaN(d));
	}
	
	protected static void assertFinite(Double d) {
		assertTrue(Double.isFinite(d));
	}
	
	protected static void assertNonNegative(Double d) {
		assertTrue(d>=0);
	}
	
	protected static void assertValidAngle(Double angle) {
		assertNotNan(angle);
		assertFinite(angle);
		assertNonNegative(angle);
		assertTrue(angle<=2*Math.PI);
	}
	
	protected abstract void assertClassInvariants();

}
