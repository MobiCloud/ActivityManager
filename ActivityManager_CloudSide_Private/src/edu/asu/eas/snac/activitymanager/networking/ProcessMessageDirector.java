package edu.asu.eas.snac.activitymanager.networking;
import edu.asu.eas.snac.activitymanager.managers.Manager;
import edu.asu.eas.snac.activitymanager.messages.AddUserToInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessagePublicVM;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import edu.asu.eas.snac.activitymanager.messages.Message;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationPublicVMMessage;
import edu.asu.eas.snac.activitymanager.messages.NewWishMessage;
import edu.asu.eas.snac.activitymanager.messages.RegisterMessage;
import edu.asu.eas.snac.activitymanager.messages.RemoveUserFromInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqInvitationMessagePublicVM;
import edu.asu.eas.snac.activitymanager.messages.ReqWishMessage;

public class ProcessMessageDirector {
	public static Message processMessage(Message m){
		
		if(m instanceof NewInvitationPublicVMMessage){
			return Manager.processMessage((NewInvitationPublicVMMessage) m);
		}
		else if(m instanceof NewWishMessage){
			return Manager.processMessage((NewWishMessage) m);
		}
		else if(m instanceof ReqInvitationMessagePublicVM){
			return Manager.processMessage((ReqInvitationMessagePublicVM) m);
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
		else if(m instanceof GetAllInvitationMessagePublicVM){
			return Manager.processMessage((GetAllInvitationMessagePublicVM)m);
		}
		else if(m instanceof AddUserToInvitationMessage){
			return Manager.processMessage((AddUserToInvitationMessage) m);
		}
		else if(m instanceof RemoveUserFromInvitationMessage){
			return Manager.processMessage((RemoveUserFromInvitationMessage) m);
		}
		
		else{
			System.out.println("COULD NOT MATCH MESSAGE");
			return null;
		}
	}
}
