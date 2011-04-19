package edu.asu.eas.snac.activitymanager.messages;

public class Message {
	private int seqNo;
	private int msgType;
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public int getSeqNo() {
		return seqNo;
	}
	public void setMsgType(int msgType) {
		this.msgType = msgType;
	}
	public int getMsgType() {
		return msgType;
	}
}
