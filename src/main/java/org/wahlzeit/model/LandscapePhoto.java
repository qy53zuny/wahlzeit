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
	
	public LandscapePhoto(String type, String weather, boolean isDay) {
		super();
		this.setType(type);
		this.setWeather(weather);
		this.setDay(isDay);
	}
	
	public LandscapePhoto(PhotoId myId, String type, String weather, boolean isDay) {
		super(myId);
		this.setType(type);
		this.setWeather(weather);
		this.setDay(isDay);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public boolean isDay() {
		return isDay;
	}

	public void setDay(boolean isDay) {
		this.isDay = isDay;
	}
}
