package org.wahlzeit.model;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CartesianCoordinate extends AbstractCoordinate {
	
	private double x;
	private double y;
	private double z;
	private static ConcurrentHashMap<Integer, CartesianCoordinate> objects = new ConcurrentHashMap<>();
	
	public double getX() {
		assertClassInvariants();
		return x;
	}

//	public void setX(double x) throws IllegalArgumentException {
//		assertClassInvariants();
//		assertParamterValueIsValid(x, "x");	
//		this.x = x;
//		assertClassInvariants();
//	}

	public double getY() {
		assertClassInvariants();
		return y;
	}

//	public void setY(double y) throws IllegalArgumentException {
//		assertClassInvariants();
//		assertParamterValueIsValid(y, "y");		
//		this.y = y;
//		assertClassInvariants();
//	}
	
	public double getZ() {
		assertClassInvariants();
		return y;
	}

//	public void setZ(double z) throws IllegalArgumentException {
//		assertClassInvariants();
//		assertParamterValueIsValid(z, "z");		
//		this.z = z;
//		assertClassInvariants();
//	}
	
	private CartesianCoordinate() {
		setCoordinate(0.0, 0.0, 0.0);
		assertClassInvariants();
	}
	
	private CartesianCoordinate(double x, double y, double z) {
		setCoordinate(x,y,z);
		assertClassInvariants();
	}

	
	private CartesianCoordinate(Coordinate coord) {
		CartesianCoordinate c = coord.asCartesianCoordinate();
		setCoordinate(c.x, c.y, c.z);
		assertClassInvariants();
	}
	
	public static CartesianCoordinate getInstance() {
		return getInstance(0,0,0);
	}
	
	public static CartesianCoordinate getInstance(Coordinate coord) {
		return coord.asCartesianCoordinate();
	}
	
	public static CartesianCoordinate getInstance(double x, double y, double z) {
		int hash = Objects.hash(x, y, z);
		return objects.computeIfAbsent(hash, key -> new CartesianCoordinate(x, y, z));
	}
	
	private void setCoordinate(double x, double y, double z) throws IllegalArgumentException {
		assertClassInvariants();
		assertParamterValueIsValid(x, "x");	
		assertParamterValueIsValid(y, "y");	
		assertParamterValueIsValid(z, "z");	
		
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
		return SphericCoordinate.getInstance(phi, theta, radius);
		
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(x, y, z);
	}
	
	public void printCoords() {
		assertClassInvariants();
		System.out.println("x: "+x);
		System.out.println("y: "+y);
		System.out.println("z: "+z);
	}
	
	protected static void assertValidCoordinateValue(Double val) throws IllegalStateException {
		assertNotNan(val);
		assertFinite(val);
	}
	
	protected void assertParamterValueIsValid(Double value, String name) throws IllegalArgumentException {
		try {
			assertValidCoordinateValue(value);
		}
		catch(IllegalStateException e) {
			throw new IllegalArgumentException("Given Argumen "+name+" is not valid: "+e.getMessage());
		}
				
	}
	
	@Override
	protected void assertClassInvariants() throws IllegalStateException {
		try {
			assertValidCoordinateValue(this.x);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("x has an invalid value: "+e.getMessage());
		}
		
		try {
			assertValidCoordinateValue(this.y);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("y has an invalid value: "+e.getMessage());
		}
		
		try {
			assertValidCoordinateValue(this.z);
		}
		catch(IllegalStateException e) {
			throw new IllegalStateException("z has an invalid value: "+e.getMessage());
		}
	}
	
}
