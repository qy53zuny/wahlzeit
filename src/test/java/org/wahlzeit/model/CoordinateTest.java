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
	
}
