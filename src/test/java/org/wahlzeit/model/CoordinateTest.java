package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CoordinateTest {
	
	@Test
	public void testCoordinateCasting() {
		CartesianCoordinate cc = new CartesianCoordinate(1,2,3);
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
		
		SphericCoordinate sc = new SphericCoordinate(a,b,c);
		assertTrue(sc.getCentralAngle(sc) == 0);
	}
	
	@Test
	public void testEquality() {
		int a = 1;
		int b = 2;
		int c = 3;
		
		CartesianCoordinate cc = new CartesianCoordinate(a,b,c);
		SphericCoordinate sc = new SphericCoordinate(cc);
		
		CartesianCoordinate cc2 = new CartesianCoordinate(b,a,c);
		
		assertFalse(sc.asCartesianCoordinate() == cc);
		assertTrue(sc.asCartesianCoordinate().hashCode() == cc.hashCode());
		assertEquals(cc, sc);
		
		assertFalse(sc.asCartesianCoordinate() == cc2);
		assertFalse(cc2.hashCode() == sc.asCartesianCoordinate().hashCode());
		assertFalse(cc2.equals(sc));
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidSphericCoordinateValuePhi() {
		SphericCoordinate sc = new SphericCoordinate();
		sc.setCoordinate(2*Math.PI, 1, 1);
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidSphericCoordinateValueTheta() {
		SphericCoordinate sc = new SphericCoordinate();
		sc.setCoordinate(1, -1, 1);
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidSphericCoordinateValueRadius() {
		SphericCoordinate sc = new SphericCoordinate();
		sc.setCoordinate(Math.PI, 1, Double.NaN);
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidCartesianCoordinateValueX() {
		CartesianCoordinate sc = new CartesianCoordinate();
		sc.setCoordinate(Double.NaN, 1, 1);
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidCartesianCoordinateValueY() {
		CartesianCoordinate sc = new CartesianCoordinate();
		sc.setCoordinate(1, Double.POSITIVE_INFINITY, 1);
	}
	
	@Test(expected = AssertionError.class)
	public void testNonvalidCartesianCoordinateValueZ() {
		CartesianCoordinate sc = new CartesianCoordinate();
		sc.setCoordinate(1, 1, Double.NEGATIVE_INFINITY);
	}
	
}
