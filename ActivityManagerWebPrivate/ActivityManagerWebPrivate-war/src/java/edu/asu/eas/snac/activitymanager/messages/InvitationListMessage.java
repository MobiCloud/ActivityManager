package edu.asu.eas.snac.activitymanager.messages;

/**
 * The list of invitations to be compacted into a message
 */
public class InvitationListMessage extends Message {
	private InvitationItem[] invitations;
	int size;
	
	public InvitationListMessage(int size){
		this.size = size;
		invitations = new InvitationItem[size];
	}
	
	public InvitationListMessage(){
		size = 0;
		setSize(0);
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
		invitations = new InvitationItem[size];
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
