package edu.asu.eas.snac.activitymanager.managers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import edu.asu.eas.snac.activitymanager.entities.User;
import edu.asu.eas.snac.activitymanager.entities.Wish;
import edu.asu.eas.snac.activitymanager.messages.AddUserToInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.FeedbackMessage;
import edu.asu.eas.snac.activitymanager.messages.FeedbackType;
import edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessagePublicVM;
import edu.asu.eas.snac.activitymanager.messages.InvitationListMessage;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import edu.asu.eas.snac.activitymanager.messages.NewInvitationPublicVMMessage;
import edu.asu.eas.snac.activitymanager.messages.NewWishMessage;
import edu.asu.eas.snac.activitymanager.messages.RegisterMessage;
import edu.asu.eas.snac.activitymanager.messages.RemoveUserFromInvitationMessage;
import edu.asu.eas.snac.activitymanager.messages.ReqInvitationMessagePublicVM;
import edu.asu.eas.snac.activitymanager.messages.ReqWishMessage;
import edu.asu.eas.snac.activitymanager.messages.WishItem;
import edu.asu.eas.snac.activitymanager.messages.WishListMessage;
import edu.asu.eas.snac.activitymanager.networking.MessageSender;

public class Manager {
	
	//the top N wishes/invites to return
	public static final int LIST_SIZE = 10;
	public static final int PUBLIC_PORT_NO = 1300;
	public static final String PUBLIC_SERVER_ADDR = "localhost";
	public static final String DB_NAME = "mobicloud";
	
	public static void main(String[] args){
		System.out.println("HERE!");
		RegisterMessage lm = new RegisterMessage();
		lm.setUsername("fredrepeat");
		lm.setPassword("pass");
		
		Manager.processMessage(lm);
	}
	
	/**
	 * This is a login message. This will attempt to log in to the system.
	 * @param m
	 * The login message containing the user's login and password info
	 * @return
	 * 
	 */
	public static FeedbackMessage processMessage(LoginMessage m){
		if(!userExists(m.getUsername())){
			return authenticate(m.getUsername(), m.getPassword());
		}
		else{
			FeedbackMessage fbm = new FeedbackMessage();
			fbm.setMsgType(FeedbackType.USER_EXIST);
			return fbm;
		}
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
			//4-21 Hashing will happen on the client side
			//String passHashed = SHA1.sha1(m.getPassword());
			
			newUser.setPassword(m.getPassword());
			newUser.setPhoneNO(m.getPhone());
			newUser.setUsername(m.getUsername());
			System.out.println("SERIALIZING ID: " + newUser.getID());
			addData(newUser);
		}
		else{
			System.out.println("The user exists");
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
	public static FeedbackMessage processMessage(NewInvitationPublicVMMessage m){
		MessageSender ms = new MessageSender();
		ms.setPort(m.getPortNumber());
		ms.setUrl(m.getVmURL());
		
		return (FeedbackMessage) ms.sendMessage(m);
	}
	
	/**
	 * This will add a new wish to the database on the person's private VM
	 * @param m
	 * @return
	 */
	public static FeedbackMessage processMessage(NewWishMessage m){
		Wish w = new Wish();
		w.setDate(m.getDate());
		w.setEndtime(m.getEndtime());
		w.setLocation(m.getLocation());
		w.setSport(m.getSport());
		w.setStarttime(m.getStarttime());
		w.setUsername(m.getUsername());
		System.out.println("This is a username: " + m.getUsername());
		addData(w);
		
		FeedbackMessage fbm = new FeedbackMessage();
		fbm.setReturnNo(FeedbackType.SUCCESS);
		return fbm;
	}
	
	/**
	 * This will get all of the user's invitations
	 * @param m
	 * @return
	 */
	public static InvitationListMessage processMessage(ReqInvitationMessagePublicVM m){
		
		MessageSender ms = new MessageSender();
		ms.setPort(m.getPortNumber());
		ms.setUrl(m.getVmURL());
		
		return (InvitationListMessage) ms.sendMessage(m);
		
	}
	
	public static InvitationListMessage processMessage(GetAllInvitationMessagePublicVM gaim){
		MessageSender ms = new MessageSender();
		ms.setPort(gaim.getPortNumber());
		ms.setUrl(gaim.getVmURL());
		
		return (InvitationListMessage) ms.sendMessage(gaim);
	}
	
	public static FeedbackMessage processMessage(AddUserToInvitationMessage m){
		MessageSender ms = new MessageSender();
		ms.setPort(m.getPortNumber());
		ms.setUrl(m.getVMURL());
		
		return (FeedbackMessage) ms.sendMessage(m);
	}
	
	public static WishListMessage processMessage(ReqWishMessage m){
		String ejbql = "select w from wishes w where w.username = ?1";
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(DB_NAME);
		EntityManager manager = factory.createEntityManager();
		
		Query q = manager.createQuery(ejbql);
		q.setParameter(1, m.getUsername());
		
		@SuppressWarnings("unchecked")
		List<Wish> lw = q.getResultList();
		
		WishListMessage wishlist = new WishListMessage(lw.size());
		
		int i = 0;
		for(Wish w : lw){
			WishItem wi = new WishItem();
			wi.setDate(w.getDate());
			wi.setEndtime(w.getEndtime());
			wi.setLocation(w.getLocation());
			wi.setSport(w.getSport());
			wi.setStarttime(w.getStarttime());
			
			wishlist.setWish(i, wi);
			i++;
		}
		
		return wishlist;
	}
	
	public static FeedbackMessage processMessage(RemoveUserFromInvitationMessage m){
		MessageSender ms = new MessageSender();
		ms.setPort(m.getPortNumber());
		ms.setUrl(m.getVMURL());
		
		return (FeedbackMessage) ms.sendMessage(m);
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
