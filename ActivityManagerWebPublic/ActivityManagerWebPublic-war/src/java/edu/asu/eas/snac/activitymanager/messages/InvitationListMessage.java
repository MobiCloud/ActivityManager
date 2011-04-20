package edu.asu.eas.snac.activitymanager.messages;

/**
 * The list of invitations to be compacted into a message
 */
public class InvitationListMessage extends Message {
	private InvitationItem[] invitations;
	
	private int size;
	
	public InvitationListMessage(){
		size = 10;
		init();
	}
	
	private void init(){
		invitations = new InvitationItem[size];
	}
	
	public InvitationListMessage(int size){
		this.size = size;
		init();
	}
	
	public void setInvitation(int offset, InvitationItem item){
		invitations[offset] = item;
	}
	
	public InvitationItem getItem(int offset){
		return invitations[offset];
	}
	
	public InvitationItem[] getAllItems(){
		return invitations;
	}
}
