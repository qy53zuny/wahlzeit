package org.wahlzeit.model;

import org.wahlzeit.services.LogBuilder;
import java.util.logging.Logger;

public class LandscapePhotoFactory extends PhotoFactory {

	private static final Logger log = Logger.getLogger(LandscapePhotoFactory.class.getName());
	private static LandscapePhotoFactory instance = null;
	
	public LandscapePhotoFactory() {
		super();
	}
	
	public static synchronized LandscapePhotoFactory getInstance() {
		
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic LandscapePhotoFactory").toString());
			setInstance(new LandscapePhotoFactory());
		}

		return instance;
	}
	
	protected static synchronized void setInstance(LandscapePhotoFactory landscapePhotoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize LandscapePhotoFactory twice");
		}

		instance = landscapePhotoFactory;
	}
	
    public LandscapePhoto createPhoto()
    {
        return new LandscapePhoto();
	}

	public LandscapePhoto createPhoto(PhotoId id)
    {
        return new LandscapePhoto(id);
    }
	
	public LandscapePhoto createPhoto(PhotoId id, String type, String weather, boolean isDay)
    {
        return new LandscapePhoto(id, type, weather, isDay);
    }
	
}
