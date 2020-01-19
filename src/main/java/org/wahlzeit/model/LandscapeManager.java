package org.wahlzeit.model;

import java.util.HashMap;

public class LandscapeManager {
	private static HashMap<Integer, Landscape> landscapeMap = new HashMap<Integer, Landscape>();
	private static HashMap<String, LandscapeType> landscapeTypeMap = new HashMap<String, LandscapeType>();
	private static int id = 0;
	private static LandscapeManager instance = new LandscapeManager();
	
	public static Landscape createLandscape(String typeName) {
		LandscapeType landscapeType = getLandscapeType(typeName);
		
		Landscape landscape = landscapeType.createInstance(id);
		landscapeMap.put(id, landscape);
		id++;
		
		return landscape;
		
	}
	
	private static LandscapeType getLandscapeType(String name) {
		return landscapeTypeMap.computeIfAbsent(name, key -> new LandscapeType(name));
	}
	
	private LandscapeManager() {
		
	}
	
	public static LandscapeManager getInstance() {
		return instance;
	}
}
