package org.wahlzeit.model;

/**
 * A landscape photo represents a user-provided (uploaded) landscape photo.
 */
public class LandscapePhoto extends Photo {

	/**
	 *
	 */
	private Landscape type;
	private String weather;
	private boolean isDay;
	private static LandscapeManager landscapeManager = LandscapeManager.getInstance();
	
	public LandscapePhoto() {
		super();
	}
	
	public LandscapePhoto(PhotoId myId) {
		super(myId);
	}
	
	public LandscapePhoto(String typeName, String weather, boolean isDay) throws IllegalArgumentException {
		super();
		assertWeather(weather);
		this.setType(typeName);
		this.setWeather(weather);
		this.setDay(isDay);
	}
	
	public LandscapePhoto(PhotoId myId, String typeName, String weather, boolean isDay) throws IllegalArgumentException {
		super(myId);
		assertWeather(weather);
		this.setType(typeName);
		this.setWeather(weather);
		this.setDay(isDay);
	}

	public String getTypeName() {
		return type.getType().getName();
	}
	
	public Landscape getType() {
		return type;
	}

	public void setType(String typeName) throws IllegalArgumentException {
		assertType(typeName);
		this.type = landscapeManager.createLandscape(typeName);
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) throws IllegalArgumentException {
		assertWeather(weather);
		this.weather = weather;
	}

	public boolean isDay() {
		return isDay;
	}

	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}
	

	protected void assertType(String typeName) throws IllegalArgumentException {
		if(typeName == null) {
			throw new IllegalArgumentException("type name cannot be null");
		}
	}
	
	protected void assertWeather(String weather) throws IllegalArgumentException {
		if(weather == null) {
			throw new IllegalArgumentException("weather must be set and cannot be null");
		}
		if(weather == "") {
			throw new IllegalArgumentException("weather must be set and cannot be empty");
		}
	}
}
