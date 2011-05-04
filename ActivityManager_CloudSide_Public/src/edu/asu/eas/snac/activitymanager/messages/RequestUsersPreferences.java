package edu.asu.eas.snac.activitymanager.messages;

public class RequestUsersPreferences extends Message {
	String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
}
