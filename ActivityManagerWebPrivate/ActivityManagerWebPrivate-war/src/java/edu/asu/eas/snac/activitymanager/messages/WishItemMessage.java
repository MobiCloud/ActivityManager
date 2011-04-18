package edu.asu.eas.snac.activitymanager.messages;

public class WishItemMessage extends Message {
	private String portNO;
	private String sessionid;
	private String sport;
	private String date;
	private String starttime;
	private String endtime;
	private String location;
	public String getPortNO() {
		return portNO;
	}
	public void setPortNO(String portNO) {
		this.portNO = portNO;
	}
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
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
}
