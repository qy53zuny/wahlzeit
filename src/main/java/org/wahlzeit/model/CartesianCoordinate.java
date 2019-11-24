package org.wahlzeit.model;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double getZ() {
		return y;
	}

	public void setZ(double y) {
		this.y = y;
	}
	
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
		
		if(this.hashCode() == c.hashCode()) {
			return isEqual(c);
		}
		else {
			return false;
		}
		
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
