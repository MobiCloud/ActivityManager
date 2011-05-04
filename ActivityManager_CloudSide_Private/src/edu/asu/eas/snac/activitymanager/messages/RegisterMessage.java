package edu.asu.eas.snac.activitymanager.messages;

public class RegisterMessage extends Message {
	private String username;
	private String password;
	private String email;
	private String phone;
	private String portNum;
	private String sessionID;
	private String IMEI;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    public String getPortNum()
    {
        return portNum;
    }
    public void setPortNum(String portNum)
    {
        this.portNum = portNum;
    }
    public String getSessionID()
    {
        return sessionID;
    }
    public void setSessionID(String sessionID)
    {
        this.sessionID = sessionID;
    }
}
