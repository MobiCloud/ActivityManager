package edu.asu.eas.snac.activitymanager.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	private String username;
	private String password;
	private String email;
	private String phoneNum;
	private String portNum;
	private String sessionID;
	private String creationDate;   
	private String IMEI;
	private String lastLogin;
	
	public int getID(){
		return userID;
	}
	
	public String getPhoneNum()
    {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum)
    {
        this.phoneNum = phoneNum;
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
    public String getCreationDate()
    {
        return creationDate;
    }
    public void setCreationDate(String creationDate)
    {
        this.creationDate = creationDate;
    }
    public String getLastLogin()
    {
        return lastLogin;
    }
    public void setLastLogin(String lastLogin)
    {
        this.lastLogin = lastLogin;
    }
    public void setUserID(int userID)
    {
        this.userID = userID;
    }
    public int getUserID(){
		return userID;
	}
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
	public String getPhoneNO() {
		return phoneNum;
	}
	public void setPhoneNO(String phoneNO) {
		this.phoneNum = phoneNO;
	}
	
}
