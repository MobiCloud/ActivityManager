package edu.asu.eas.snac.activitymanager.messages;

public class NewInvitationMessage extends Message {
	private String sport;
	private String date;
	private String starttime;
	private String endtime;
	private String location;
	private int maxgamer;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getMaxgamer() {
		return maxgamer;
	}
	public void setMaxgamer(int maxgamer) {
		this.maxgamer = maxgamer;
	}
}
