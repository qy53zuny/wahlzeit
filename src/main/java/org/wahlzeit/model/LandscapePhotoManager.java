package org.wahlzeit.model;

import com.google.appengine.api.images.Image;

public class LandscapePhotoManager extends PhotoManager {

	public LandscapePhotoManager() {
		photoTagCollector = LandscapePhotoFactory.getInstance().createPhotoTagCollector();
	}
	
   @Override
	public Photo getPhotoFromId(PhotoId id)
   {
	    if (id == null) {
	    	return null;
		}

       Photo result = doGetPhotoFromId(id);

       if (result == null)
       {
           result = LandscapePhotoFactory.getInstance().loadPhoto(id);
           if (result != null) {
        	   doAddPhoto(result);
           }
       }
       return result;
   }
   
	@Override
	public LandscapePhoto createPhoto(String filename, Image uploadedImage) throws Exception {
		PhotoId id = PhotoId.getNextId();
		LandscapePhoto result = PhotoUtil.createLandscapePhoto(filename, id, uploadedImage);
		addPhoto(result);
		return result;
	}
}
