package edu.asu.eas.snac.activitymanager.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import edu.asu.eas.snac.activitymanager.entities.Invitation;
import edu.asu.eas.snac.activitymanager.entities.User;
import edu.asu.eas.snac.activitymanager.entities.UsersInInvitations;
import edu.asu.eas.snac.activitymanager.messages.AddUserToInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.FeedbackMessage;
import edu.asu.eas.snac.activitymanager.messages.FeedbackType;
import edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.InvitationItem;
import edu.asu.eas.snac.activitymanager.messages.InvitationListMessage;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import edu.asu.eas.snac.activitymanager.messages.Message;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.NewWishMessage;
import edu.asu.eas.snac.activitymanager.messages.RegisterMessage;
import edu.asu.eas.snac.activitymanager.messages.RemoveUserFromInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqWishMessage;
import edu.asu.eas.snac.activitymanager.messages.WishListMessage;
import edu.asu.eas.snac.activitymanager.util.SHA1;

public class Manager {
	
	//the top N wishes/invites to return
	public static final int LIST_SIZE = 10;
	public static final int PRIVATE_PORT_NO = 8507;
	public static final String DB_NAME = "mobicloud";
	
	
	public static void main(String[] args){
		
//		NewInvitationMessage nim = new NewInvitationMessage();
//		nim.setUsername("fred");
//		nim.setSport("Soccer");
//		Manager.processMessage((NewInvitationMessage) nim);
//		System.out.println("added");
		
//		AddUserToInvitationMessage adduser = new AddUserToInvitationMessage();
//		adduser.setInviteID(1);
//		adduser.setUsername("fred");
//		Manager.processMessage((AddUserToInvitationMessage) adduser);
		
		RemoveUserFromInvitationMessage remove = new RemoveUserFromInvitationMessage();
		remove.setUsername("fred");
		remove.setInviteID(1);
		Manager.processMessage((RemoveUserFromInvitationMessage)remove);
	}
	
	/**
	 * This is a login message. This will attempt to log in to the system.
	 * @param m
	 * The login message containing the user's login and password info
	 * @return
	 * 
	 */
	public static FeedbackMessage processMessage(LoginMessage m){
		return authenticate(m.getUsername(), m.getPassword());
	}

	/**
	 * This will attempt to register a user on the system.
	 * @param m
	 * The register message.
	 * @return
	 * If the register was successful
	 */
	public static FeedbackMessage processMessage(RegisterMessage m){
		FeedbackMessage fbm = new FeedbackMessage();
		if(!userExists(m.getUsername())){
			User newUser = new User();
			newUser.setEmail(m.getEmail());
			newUser.setIMEI(m.getIMEI());
			
			//we do not want to save a raw version of the file, but instead the SHA-1 Hash of the file.
			String passHashed = SHA1.sha1(m.getPassword());
			
			newUser.setPassword(passHashed);
			newUser.setPhoneNO(m.getPhone());
			newUser.setUsername(m.getUsername());
			System.out.println("SERIALIZING ID: " + newUser.getID());
			addData(newUser);
		}
		else{
			fbm.setMsgType(FeedbackType.USER_EXIST);
		}
		
		return fbm;
	}
	
	/**
	 * This will add a new invitation to the database
	 * @param m
	 * The new invitation message
	 * @return
	 */
	public static FeedbackMessage processMessage(NewInvitationMessage m){
		Invitation i = new Invitation();
		i.setDate(m.getDate());
		i.setEndtime(m.getEndtime());
		i.setLocation(m.getLocation());
		i.setMaxGamer(m.getMaxgamer());
		i.setSport(m.getSport());
		i.setStarttime(m.getStarttime());
		i.setUsername(m.getUsername());
		addData(i);
		
		//add the user to the message
		AddUserToInvitationMessage autim = new AddUserToInvitationMessage();
		autim.setUsername(m.getUsername());
		autim.setInviteID(i.getInviteID());
		processMessage((AddUserToInvitationMessage) autim);
		
		FeedbackMessage fbm = new FeedbackMessage();
		fbm.setMsgType(FeedbackType.SUCCESS);
		
		return fbm;
	}
	
	/**
	 * 
	 * @param m The message containing the data we wish to add to the server
	 * @return
	 */
	public static Message processMessage(AddUserToInvitationMessage m) {
		UsersInInvitations userInGame = new UsersInInvitations();
		userInGame.setInviteID(m.getInviteID());
		userInGame.setUsername(m.getUsername());
		addData(userInGame);
		
		//update the invitation count
		String updateEjbql = "update invitation i set i.currentgamer = (i.currentgamer + 1) where i.inviteID = ?1";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Query incQuery = manager.createQuery(updateEjbql);
		incQuery.setParameter(1, m.getInviteID());
		System.out.println("INCREMENTING INVITATION " + m.getInviteID());
		incQuery.executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		factory.close();
		
		FeedbackMessage fbm = new FeedbackMessage();
		fbm.setMsgType(FeedbackType.SUCCESS);
		
		return fbm;
	}
	
	/**
	 * This will add a new wish to the database on the person's private VM
	 * @param m
	 * @return
	 */
	public static FeedbackMessage processMessage(NewWishMessage m){
		FeedbackMessage fbm = new FeedbackMessage();
		fbm.setMsgType(FeedbackType.SUCCESS * -1 );
		return fbm;
	}
	
	/**
	 * This will get all of the user's invitations
	 * @param m
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static InvitationListMessage processMessage(ReqInvitationMessage m){
		String ejbql = "select b from invitation b where b.username = ?1";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery(ejbql);
		q.setParameter(1, m.getUsername());
		
		List<Invitation> l = q.getResultList();
		
		InvitationListMessage ilm = new InvitationListMessage(l.size());
		
		for(int i = 0 ; i < l.size(); i++){
			Invitation tmp = l.get(i);
			InvitationItem item = new InvitationItem();
			item = new InvitationItem();
			item.setDate(tmp.getDate());
			item.setEndtime(tmp.getEndtime());
			item.setLocation(tmp.getLocation());
			item.setMaxgamer(tmp.getMaxGamer());
			item.setSport(tmp.getSport());
			item.setStarttime(tmp.getStarttime());
			ilm.setInvitation(i, item);
		}

		return ilm;
	}
	
	@SuppressWarnings("unchecked")
	public static InvitationListMessage processMessage(GetAllInvitationMessage gaim){
		
		System.out.println("I AM Here!!!!!!!!");
		
		String ejbql = "select b from invitation b";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery(ejbql);
		
		List<Invitation> l = q.getResultList();
		
		InvitationListMessage ilm = new InvitationListMessage(l.size());
		
		String userQueryString = "select ui from usersininvitations ui where ui.inviteID = ?1 and ui.username = ?2";
		Query userQuery;
		for(int i = 0 ; i < l.size(); i++){
			Invitation tmp = l.get(i);
			InvitationItem item = new InvitationItem();
			item = new InvitationItem();
			System.out.println("invite ID: " + tmp.getInviteID());
			item.setInviteID(tmp.getInviteID());
			item.setDate(tmp.getDate());
			item.setEndtime(tmp.getEndtime());
			item.setLocation(tmp.getLocation());
			item.setMaxgamer(tmp.getMaxGamer());
			item.setSport(tmp.getSport());
			item.setStarttime(tmp.getStarttime()); 
			item.setCurrentgamer(tmp.getCurrentgamer());
			
			//check to see if the user is on the game. If they are, mark the boolean fla
			userQuery = manager.createQuery(userQueryString);
			userQuery.setParameter(1, tmp.getInviteID());
			userQuery.setParameter(2, gaim.getUsername());
			System.out.println("Trying to make a query");
			List<UsersInInvitations> uis = userQuery.getResultList();
			System.out.println("Made a query");
			
			item.setUserOnGame(uis.size() > 0);
			
			ilm.setInvitation(i, item);
		}

		return ilm;
	}
	
	public static Message processMessage(RemoveUserFromInvitationMessage m) {
		
		
		String deleteEjbql = "delete from usersininvitations ui where ui.username = ?1 and ui.inviteID = ?2";
		String updateEjbql = "update invitation i set i.currentgamer = (i.currentgamer - 1) where i.inviteID = ?1";
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		FeedbackMessage fbm = new FeedbackMessage();
		fbm.setMsgType(FeedbackType.SUCCESS);
		try{
			
			manager.getTransaction().begin();
			Query deleteQuery = manager.createQuery(deleteEjbql);
			deleteQuery.setParameter(1, m.getUsername());
			deleteQuery.setParameter(2, m.getInviteID());
			System.out.println("Deleted: " + deleteQuery.executeUpdate() + " record(s).");
			manager.getTransaction().commit();
			
			
			manager.getTransaction().begin();
			Query updateQuery = manager.createQuery(updateEjbql);
			updateQuery.setParameter(1, m.getInviteID());
			System.out.println("DECREMENTING INVITATION " + m.getInviteID());
			System.out.println("Updated: " + updateQuery.executeUpdate() + " record(s).");
			manager.getTransaction().commit();
			
			manager.close();
			factory.close();
		}catch(PersistenceException ex){
			ex.printStackTrace();
			fbm.setMsgType(FeedbackType.SUCCESS * -1);
		}
		
		return fbm;
	}
	
	public static WishListMessage processMessage(ReqWishMessage m){
		return null;
	}
	
	//return 0 on success and 1 on failure
	
	public static FeedbackMessage authenticate(String username, String password){
		String ejbql = "select u from users u where u.username = ?1";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery(ejbql);
		q.setParameter(1, username);
		
		//check if username exists
		@SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
		
		//set the password to the SHA-1 hash s.t. we are comparing the right strings
		password = SHA1.sha1(password);
		
		FeedbackMessage fbm = new FeedbackMessage();
		if(users.size() > 0){
			fbm.setReturnNo(users.get(0).getPassword().equals(password) ? FeedbackType.SUCCESS : FeedbackType.WRONG_USER_PASS);
		}
		else{
			fbm.setReturnNo(FeedbackType.WRONG_USER_PASS);
		}
		return fbm;
	}
	
	@SuppressWarnings({ "unchecked" })
	private static boolean userExists(String username){
		String ejbql = "select u from users u where u.username = ?1";
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery(ejbql);
		q.setParameter(1, username);
		
		//check if username exists
		List<User> users = q.getResultList();
		return users.size() > 0;
	}
	
	private static void addData(Object o){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(o);
		manager.getTransaction().commit();
		manager.close();
	}
	
	@SuppressWarnings("unused")
	private static String sessionToUser(String sessionID){
		return "" + sessionID;
	}
}
