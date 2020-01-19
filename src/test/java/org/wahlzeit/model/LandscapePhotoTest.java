package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class LandscapePhotoTest {

	@Test
	public void testEmptyLandscapePhoto() {
		
		LandscapePhoto photo = new LandscapePhoto();
		Assert.assertNotNull(photo.getId());
		
	}
	
	@Test
	public void testFullLandscapePhoto() {
		
		String type = "mountains";
		String weather = "sunny";
		boolean isDay = true;
		LandscapePhoto photo = new LandscapePhoto(type, weather, isDay);
		
		Assert.assertTrue(photo.getTypeName().equals(type));
		Assert.assertTrue(photo.getType().getType().getName().equals(type));
		Assert.assertTrue(photo.getWeather().equals(weather));
		Assert.assertTrue(photo.isDay());
		Assert.assertNotNull(photo.getId());
		
	}
	
	@Test public void testFullLandscapePhotoWithId() {
		
		PhotoId id = new PhotoId(4711);
		String type = "mountains";
		String weather = "sunny";
		boolean isDay = true;
		LandscapePhoto photo = new LandscapePhoto(id, type, weather, isDay);
		
		Assert.assertTrue(photo.getTypeName().equals(type));
		Assert.assertTrue(photo.getWeather().equals(weather));
		Assert.assertTrue(photo.isDay());
		Assert.assertNotNull(photo.getId());
		Assert.assertTrue(photo.getId().value == 4711);
		
	}

}
