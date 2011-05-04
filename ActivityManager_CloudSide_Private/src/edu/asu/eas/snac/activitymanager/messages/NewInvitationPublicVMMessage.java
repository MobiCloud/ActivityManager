package edu.asu.eas.snac.activitymanager.messages;

public class NewInvitationPublicVMMessage extends NewInvitationMessage {
	private String vmURL;
	private int portNumber;
	public String getVmURL() {
		return vmURL;
	}
	public void setVmURL(String vmURL) {
		this.vmURL = vmURL;
	}
	public int getPortNumber() {
		return portNumber;
	}
	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	
	
}
