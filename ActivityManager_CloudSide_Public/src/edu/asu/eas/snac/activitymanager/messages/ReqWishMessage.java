package edu.asu.eas.snac.activitymanager.messages;

public class ReqWishMessage extends Message {
	private String username;
	private String privateVMPort;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPrivateVMURL() {
		return privateVMPort;
	}

	public void setPrivateVMURL(String privateVMPort) {
		this.privateVMPort = privateVMPort;
	}
}
