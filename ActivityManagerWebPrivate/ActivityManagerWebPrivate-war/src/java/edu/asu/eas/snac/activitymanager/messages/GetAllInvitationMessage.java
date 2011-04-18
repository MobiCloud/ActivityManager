package edu.asu.eas.snac.activitymanager.messages;

public class GetAllInvitationMessage extends Message{
	private String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
