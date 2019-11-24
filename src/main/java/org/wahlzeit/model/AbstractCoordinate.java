package org.wahlzeit.model;

public abstract class AbstractCoordinate implements Coordinate {

	private static final double EPSILON = 0.001;
	
	@Override
	public double getCartesianDistance(Coordinate coord) {
		
		if(coord == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		CartesianCoordinate thisCartesian = this.asCartesianCoordinate();
		CartesianCoordinate c = coord.asCartesianCoordinate();
		
		if(this.isEqual(c)) {
			return 0;
		}
		
		return Math.sqrt(Math.pow((c.getX()-thisCartesian.getX()),2) + Math.pow((c.getY()-thisCartesian.getY()),2) + Math.pow((c.getZ()-thisCartesian.getZ()),2));
	}

	@Override
	public double getCentralAngle(Coordinate coordinate) {
		
		if(coordinate == null) {
			throw new IllegalArgumentException("Coordinate must not be null.");
		}
		
		SphericCoordinate thisSpheric = this.asSphericCoordinate();
		SphericCoordinate c = coordinate.asSphericCoordinate();
		
		double phiDif = Math.abs(thisSpheric.getPhi()-c.getPhi());
		double thetaDif = Math.abs(thisSpheric.getTheta()-c.getTheta());
		double res = Math.sin(thetaDif/2);
		res = res*res*Math.cos(thisSpheric.getPhi())*Math.cos(c.getPhi()) + Math.pow(Math.sin(phiDif/2), 2);
		res = 2*Math.asin(Math.sqrt(res));
		return res;
	}

	@Override
	public boolean isEqual(Coordinate coord) {
		
		if(coord==null) {
			return false;
		}
		
		CartesianCoordinate thisCartesian = this.asCartesianCoordinate();
		CartesianCoordinate c = coord.asCartesianCoordinate();		
		
		if((Math.abs(thisCartesian.getX()-c.getX()) < EPSILON) && (Math.abs(thisCartesian.getY()-c.getY()) < EPSILON) && (Math.abs(thisCartesian.getZ()-c.getZ()) < EPSILON)) {
			return true;
		}
		
		return false;
	}

}
