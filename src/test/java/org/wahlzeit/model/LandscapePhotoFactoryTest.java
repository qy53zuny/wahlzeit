package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class LandscapePhotoFactoryTest {
	
	private LandscapePhotoFactory factory;
	
	@Before
	public void setup() {
		this.factory = new LandscapePhotoFactory();
	}

	@Test
	public void testCreatePhoto() {
		LandscapePhoto photo = factory.createPhoto();
		Assert.assertNotNull(photo);
	}
	

	@Test
	public void testCreatePhotoWithPhotoId() {
		PhotoId id = new PhotoId(1337);
		LandscapePhoto photo = factory.createPhoto(id);
		Assert.assertNotNull(photo);
		Assert.assertEquals(id, photo.getId());
		Assert.assertEquals(photo, factory.loadPhoto(id));
	}

}
