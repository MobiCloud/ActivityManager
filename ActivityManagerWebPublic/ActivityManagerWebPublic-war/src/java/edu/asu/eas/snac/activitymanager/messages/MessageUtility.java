package edu.asu.eas.snac.activitymanager.messages;

import java.util.ArrayList;

public class MessageUtility {
	
	public static Message convertTranssmitableMessageToMessage(TransmittableMessage msg){
		Message message = null;
		switch (msg.getMsgType()){
			case MessageType.FEEDBACK_MSG:
				FeedbackMessage feedbackMsg = new FeedbackMessage();
				feedbackMsg.setSeqNo(msg.getSeqNo());
				feedbackMsg.setMsgType(msg.getMsgType());
				feedbackMsg.setReturnNo((Integer) msg.getData()[0]);
				message = feedbackMsg;
				break;		
			case MessageType.LOGIN_MSG:
				LoginMessage loginMsg = new LoginMessage();
				loginMsg.setSeqNo(msg.getSeqNo());
				loginMsg.setMsgType(msg.getMsgType());
				loginMsg.setUsername((String)msg.getData()[0]);
				loginMsg.setPassword((String)msg.getData()[1]);
				message = loginMsg;
				break;
			case MessageType.REGISTER_MSG:
				RegisterMessage regMsg = new RegisterMessage();
				regMsg.setSeqNo(msg.getSeqNo());
				regMsg.setMsgType(msg.getMsgType());
				regMsg.setUsername((String)msg.getData()[0]);
				regMsg.setPassword((String)msg.getData()[1]);
				regMsg.setIMEI((String)msg.getData()[2]);
				regMsg.setEmail((String)msg.getData()[3]);
				regMsg.setPhone((String)msg.getData()[4]);
				message = regMsg;
				break;
			case MessageType.ADD_NEW_INVITATION_MSG:
				NewInvitationMessage newInMsg = new NewInvitationMessage();
				newInMsg.setSeqNo(msg.getSeqNo());
				newInMsg.setMsgType(msg.getMsgType());
				newInMsg.setSport((String)msg.getData()[0]);
				newInMsg.setDate((String)msg.getData()[1]);
				newInMsg.setStarttime((String)msg.getData()[2]);
				newInMsg.setEndtime((String)msg.getData()[3]);
				newInMsg.setLocation((String)msg.getData()[4]);
				newInMsg.setMaxgamer((Integer)msg.getData()[5]);
				message = newInMsg;
				break;
			case MessageType.ADD_NEW_WISH_MSG:
				NewWishMessage newWishMsg = new NewWishMessage();
				newWishMsg.setSeqNo(msg.getSeqNo());
				newWishMsg.setMsgType(msg.getMsgType());
				newWishMsg.setSport((String)msg.getData()[0]);
				newWishMsg.setDate((String)msg.getData()[1]);
				newWishMsg.setStarttime((String)msg.getData()[2]);
				newWishMsg.setEndtime((String)msg.getData()[3]);
				newWishMsg.setLocation((String)msg.getData()[4]);
				message = newWishMsg;
				break;
			case MessageType.REQUEST_INVITATION:
				ReqInvitationMessage reqInMsg = new ReqInvitationMessage();
				break;
			case MessageType.REQUEST_WISH:
				ReqWishMessage reqWishMsg = new ReqWishMessage();
				break;
			case MessageType.CURRENT_INVITATION:
				InvitationItemMessage inMsg = new InvitationItemMessage();
				inMsg.setSeqNo(msg.getSeqNo());
				inMsg.setMsgType(msg.getMsgType());
				inMsg.setSport((String)msg.getData()[0]);
				inMsg.setDate((String)msg.getData()[1]);
				inMsg.setStarttime((String)msg.getData()[2]);
				inMsg.setEndtime((String)msg.getData()[3]);
				inMsg.setLocation((String)msg.getData()[4]);
				inMsg.setMaxgamer((Integer)msg.getData()[5]);
				message = inMsg;				
				break;
			case MessageType.CURRENT_WISH:
				NewWishMessage wishMsg = new NewWishMessage();
				wishMsg.setSeqNo(msg.getSeqNo());
				wishMsg.setMsgType(msg.getMsgType());
				wishMsg.setSport((String)msg.getData()[0]);
				wishMsg.setDate((String)msg.getData()[1]);
				wishMsg.setStarttime((String)msg.getData()[2]);
				wishMsg.setEndtime((String)msg.getData()[3]);
				wishMsg.setLocation((String)msg.getData()[4]);
				message = wishMsg;				
				break;
			case MessageType.SESSION_MSG:
				SessionMessage sessionMsg = new SessionMessage(
						msg.getSeqNo(),
						(Integer)msg.getData()[0], 
						(String)msg.getData()[1], 
						(String)msg.getData()[2]);
				message = sessionMsg;
				break;	
		}
		return  message;
	}
	
	public static TransmittableMessage convertMessageToTransmittableMessage(Message msg){
		TransmittableMessage message = new TransmittableMessage();
		ArrayList<Object> dataList = new ArrayList<Object>();
		Object[] data = null;
		switch (msg.getMsgType()){
			case MessageType.FEEDBACK_MSG:
				FeedbackMessage feefbackMsg = (FeedbackMessage)msg;
				dataList.add(feefbackMsg.getReturnNo());
				data = dataList.toArray();
				break;
			case MessageType.LOGIN_MSG:
				LoginMessage loginMsg = (LoginMessage) msg;
				dataList.add(loginMsg.getUsername());
				dataList.add(loginMsg.getPassword());
				data = dataList.toArray();
				break;
			case MessageType.REGISTER_MSG:
				RegisterMessage regMsg = (RegisterMessage)msg;
				dataList.add(regMsg.getUsername());
				dataList.add(regMsg.getPassword());
				dataList.add(regMsg.getIMEI());
				dataList.add(regMsg.getEmail());
				dataList.add(regMsg.getPhone());
				data = dataList.toArray();
				break;
			case MessageType.ADD_NEW_INVITATION_MSG:
				NewInvitationMessage newInMsg = (NewInvitationMessage)msg;
				dataList.add(newInMsg.getSport());
				dataList.add(newInMsg.getDate());
				dataList.add(newInMsg.getStarttime());
				dataList.add(newInMsg.getEndtime());
				dataList.add(newInMsg.getLocation());
				dataList.add(newInMsg.getMaxgamer());
				data = dataList.toArray();
				break;
			case MessageType.ADD_NEW_WISH_MSG:
				NewWishMessage newWishMsg = (NewWishMessage)msg;
				dataList.add(newWishMsg.getSport());
				dataList.add(newWishMsg.getDate());
				dataList.add(newWishMsg.getStarttime());
				dataList.add(newWishMsg.getEndtime());
				dataList.add(newWishMsg.getLocation());
				data = dataList.toArray();
				break;
			case MessageType.REQUEST_INVITATION:
				ReqInvitationMessage reqInMsg = (ReqInvitationMessage)msg;
				break;
			case MessageType.REQUEST_WISH:
				ReqWishMessage reqWishMsg = (ReqWishMessage)msg;
				break;
			case MessageType.CURRENT_INVITATION:
				InvitationItemMessage inMsg = (InvitationItemMessage)msg;
				dataList.add(inMsg.getSport());
				dataList.add(inMsg.getDate());
				dataList.add(inMsg.getStarttime());
				dataList.add(inMsg.getEndtime());
				dataList.add(inMsg.getLocation());
				dataList.add(inMsg.getMaxgamer());				
				break;
			case MessageType.CURRENT_WISH:
				NewWishMessage wishMsg = (NewWishMessage)msg;
				dataList.add(wishMsg.getSport());
				dataList.add(wishMsg.getDate());
				dataList.add(wishMsg.getStarttime());
				dataList.add(wishMsg.getEndtime());
				dataList.add(wishMsg.getLocation());
				data = dataList.toArray();				
				break;				
			case MessageType.SESSION_MSG:
				SessionMessage sessionMsg  = (SessionMessage) msg;
				dataList.add(sessionMsg.getPort());
				dataList.add(sessionMsg.getSessionId());
				dataList.add(sessionMsg.getUsername());
				data = dataList.toArray();
				break;
		}
		message.setSeqNo(msg.getSeqNo());
		message.setMsgType(msg.getMsgType());
		message.setData(data);
		return  message;
	}
	
}
