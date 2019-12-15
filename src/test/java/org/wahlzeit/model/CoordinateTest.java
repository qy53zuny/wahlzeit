package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CoordinateTest {
	
	@Test
	public void testCoordinateCasting() {
		CartesianCoordinate cc = CartesianCoordinate.getInstance(1,2,3);
		SphericCoordinate sc = cc.asSphericCoordinate();
		CartesianCoordinate cc2 = sc.asCartesianCoordinate();
		
		//cc2.printCoords();
		
		assertTrue(cc.equals(sc));
		assertTrue(cc2.equals(sc));
		assertTrue(cc.equals(cc2));
	}
	
	@Test
	public void testCentralAngle() {
		int a = 1;
		int b = 2;
		int c = 3;
		
		SphericCoordinate sc = SphericCoordinate.getInstance(a,b,c);
		assertTrue(sc.getCentralAngle(sc) == 0);
	}
	
	@Test
	public void testEquality() {
		int a = 1;
		int b = 2;
		int c = 3;
		
		CartesianCoordinate cc = CartesianCoordinate.getInstance(a,b,c);
		SphericCoordinate sc = SphericCoordinate.getInstance(cc);
		
		CartesianCoordinate cc2 = CartesianCoordinate.getInstance(b,a,c);
		
		assertTrue(sc.asCartesianCoordinate() == cc);
		assertTrue(sc.asCartesianCoordinate().hashCode() == cc.hashCode());
		assertEquals(cc, sc);
		
		assertFalse(sc.asCartesianCoordinate() == cc2);
		assertFalse(cc2.hashCode() == sc.asCartesianCoordinate().hashCode());
		assertFalse(cc2.equals(sc));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidSphericCoordinateValuePhi() {
		SphericCoordinate sc = SphericCoordinate.getInstance();
		sc = SphericCoordinate.getInstance(2*Math.PI, 1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidSphericCoordinateValueTheta() {
		SphericCoordinate sc = SphericCoordinate.getInstance();
		sc = SphericCoordinate.getInstance(1, -1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidSphericCoordinateValueRadius() {
		SphericCoordinate sc = SphericCoordinate.getInstance();
		sc = SphericCoordinate.getInstance(Math.PI, 1, Double.NaN);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidCartesianCoordinateValueX() {
		CartesianCoordinate cc = CartesianCoordinate.getInstance();
		cc = CartesianCoordinate.getInstance(Double.NaN, 1, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidCartesianCoordinateValueY() {
		CartesianCoordinate cc = CartesianCoordinate.getInstance();
		cc = CartesianCoordinate.getInstance(1, Double.POSITIVE_INFINITY, 1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNonvalidCartesianCoordinateValueZ() {
		CartesianCoordinate cc = CartesianCoordinate.getInstance();
		cc = CartesianCoordinate.getInstance(1, 1, Double.NEGATIVE_INFINITY);
	}
	
}
