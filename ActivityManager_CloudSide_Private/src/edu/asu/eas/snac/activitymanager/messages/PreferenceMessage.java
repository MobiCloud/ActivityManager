package edu.asu.eas.snac.activitymanager.messages;

import java.util.HashMap;
import java.util.Map;

public class PreferenceMessage extends Message {
	Map<String, Double> prefMap;
	
	public PreferenceMessage(){
		prefMap = new HashMap<String, Double>();
	}
	
	public void addSet(String name, double rating){
		prefMap.put(name, rating);
	}
	
	public Map<String, Double> getRatings(){
		return prefMap;
	}
}