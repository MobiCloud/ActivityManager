package edu.asu.eas.snac.activitymanager.messages;

public class InvitationItem extends Message {
	private String sport;
	private String date;
	private String starttime;
	private String endtime;
	private String location;
	private int currentgamer;
	private int inviteID;
	private int maxgamer;
	private boolean isUserOnGame;
	
	
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID = inviteID;
	}
	public InvitationItem(){
		isUserOnGame = false;
	}
	public boolean isUserOnGame() {
		return isUserOnGame;
	}
	public void setUserOnGame(boolean isUserOnGame) {
		this.isUserOnGame = isUserOnGame;
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
	
	public int getCurrentgamer() {
		return currentgamer;
	}
	public void setCurrentgamer(int currentgamer) {
		this.currentgamer = currentgamer;
	}
	public int getMaxgamer() {
		return maxgamer;
	}
	public void setMaxgamer(int maxgamer) {
		this.maxgamer = maxgamer;
	}
}
