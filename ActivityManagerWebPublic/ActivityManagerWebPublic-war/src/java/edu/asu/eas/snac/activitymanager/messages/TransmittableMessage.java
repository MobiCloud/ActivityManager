package edu.asu.eas.snac.activitymanager.messages;

import java.io.Serializable;

public class TransmittableMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2456036277654134426L;
	private Object[] data;
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
	public void setData(Object[] data) {
		this.data = data;
	}

	public Object[] getData() {
		return data;
	}
	
}
