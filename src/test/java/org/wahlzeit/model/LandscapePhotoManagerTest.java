package org.wahlzeit.model;

import org.junit.Assert;
import org.junit.Test;

public class LandscapePhotoManagerTest {

	
	@Test
	public void testInstanceEquality() {
		PhotoManager manager1 = LandscapePhotoManager.getInstance();
		PhotoManager manager2 = PhotoManager.getInstance();
		Assert.assertEquals(manager1, manager2);
	}

}
