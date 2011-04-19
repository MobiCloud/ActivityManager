package edu.asu.eas.snac.activitymanager.messages;

public class SessionMessage extends Message{
	private int port;
	private String sessionId;
	private String username;
	
	public SessionMessage (int seqNo, int port, String sessionId, String username) {
		this.setSeqNo(seqNo);
		this.setMsgType(MessageType.SESSION_MSG);
		this.setPort(port);
		this.setSessionId(sessionId);
		this.setUsername(username);
	}
	public String toString() {
		return this.getSeqNo() + ", " + this.getMsgType() + ", " 
		+ this.getSessionId() + ", " + this.getPort() + ", " + this.getUsername();
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getPort() {
		return port;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	
}
