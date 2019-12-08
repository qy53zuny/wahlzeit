package org.wahlzeit.model;

/**
 * A landscape photo represents a user-provided (uploaded) landscape photo.
 */
public class LandscapePhoto extends Photo {

	/**
	 *
	 */
	private String type;
	private String weather;
	private boolean isDay;
	
	public LandscapePhoto() {
		super();
	}
	
	public LandscapePhoto(PhotoId myId) {
		super(myId);
	}
	
	public LandscapePhoto(String type, String weather, boolean isDay) throws IllegalArgumentException {
		super();
		assertWeather(weather);
		assertType(type);
		this.setType(type);
		this.setWeather(weather);
		this.setDay(isDay);
	}
	
	public LandscapePhoto(PhotoId myId, String type, String weather, boolean isDay) throws IllegalArgumentException {
		super(myId);
		assertWeather(weather);
		assertType(type);
		this.setType(type);
		this.setWeather(weather);
		this.setDay(isDay);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws IllegalArgumentException {
		assertType(type);
		this.type = type;
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
	

	protected void assertType(String type) throws IllegalArgumentException {
		if(type == null) {
			throw new IllegalArgumentException("type cannot be null");
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
