package edu.asu.eas.snac.activitymanager.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="usersininvitations")
public class UsersInInvitations {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="inviteUserID")
	private int inviteUserID;
	@Column(name="username")
	private String username;
	@Column(name="inviteID")
	private int inviteID;
	public int getInviteUserID() {
		return inviteUserID;
	}
	public void setInviteUserID(int inviteUserID) {
		this.inviteUserID = inviteUserID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getInviteID() {
		return inviteID;
	}
	public void setInviteID(int inviteID) {
		this.inviteID = inviteID;
	}
}
