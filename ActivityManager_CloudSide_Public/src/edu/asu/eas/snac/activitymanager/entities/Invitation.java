package edu.asu.eas.snac.activitymanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="invitation")
public class Invitation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int inviteID;
	private String username;
	private String sport;
	private String date;
	private String starttime;
	private String endtime;
	private String location;
	private int currentgamer;
	private int maxgamer;
	
	
	public int getCurrentgamer() {
		return currentgamer;
	}
	public void setCurrentgamer(int currentgamer) {
		this.currentgamer = currentgamer;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getMaxgamer() {
		return maxgamer;
	}
	public void setMaxgamer(int maxgamer) {
		this.maxgamer = maxgamer;
	}
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID = inviteID;
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
	public int getMaxGamer() {
		return maxgamer;
	}
	public void setMaxGamer(int maxGamer) {
		this.maxgamer = maxGamer;
	}
	
}
