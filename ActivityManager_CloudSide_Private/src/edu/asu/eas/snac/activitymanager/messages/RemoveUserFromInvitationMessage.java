package edu.asu.eas.snac.activitymanager.messages;

public class RemoveUserFromInvitationMessage extends Message {

	private String username;
	private int inviteID;
	private String VMURL;
	private int portNumber;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID = inviteID;
	}
	public String getVMURL() {
		return VMURL;
	}
	public void setVMURL(String vMURL) {
		VMURL = vMURL;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	
	
}
