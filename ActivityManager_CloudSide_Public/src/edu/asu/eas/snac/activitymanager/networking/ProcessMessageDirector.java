package edu.asu.eas.snac.activitymanager.networking;
import edu.asu.eas.snac.activitymanager.managers.Manager;
import edu.asu.eas.snac.activitymanager.messages.AddUserToInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import edu.asu.eas.snac.activitymanager.messages.Message;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.NewWishMessage;
import edu.asu.eas.snac.activitymanager.messages.RegisterMessage;
import edu.asu.eas.snac.activitymanager.messages.RemoveUserFromInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqWishMessage;

public class ProcessMessageDirector {
	public static Message processMessage(Message m){
		
		if(m instanceof NewInvitationMessage){
			return Manager.processMessage((NewInvitationMessage) m);
		}
		else if(m instanceof NewWishMessage){
			return Manager.processMessage((NewWishMessage) m);
		}
		else if(m instanceof ReqInvitationMessage){
			return Manager.processMessage((ReqInvitationMessage) m);
		}
		else if(m instanceof ReqWishMessage){
			return Manager.processMessage((ReqWishMessage) m);
		}
		else if(m instanceof LoginMessage){
			return Manager.processMessage((LoginMessage) m);
		}
		else if(m instanceof RegisterMessage){
			return Manager.processMessage((RegisterMessage) m);
		}
		else if(m instanceof GetAllInvitationMessage){
			return Manager.processMessage((GetAllInvitationMessage)m);
		}
		else if(m instanceof AddUserToInvitationMessage){
			return Manager.processMessage((AddUserToInvitationMessage) m);
		}
		else if(m instanceof RemoveUserFromInvitationMessage){
			return Manager.processMessage((RemoveUserFromInvitationMessage) m);
		}
		
		else return null;
	}
}
