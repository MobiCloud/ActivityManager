package edu.asu.eas.snac.activitymanager.networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import edu.asu.eas.snac.activitymanager.managers.Manager;
import edu.asu.eas.snac.activitymanager.messages.GetAllInvitationMessagePublicVM;
import edu.asu.eas.snac.activitymanager.messages.Message;


public class MessageSender {
	
	public static void main(String[] args){
		GetAllInvitationMessagePublicVM gaim = new GetAllInvitationMessagePublicVM();
		gaim.setPortNumber(1337);
		gaim.setVmURL("mobicloud.asu.edu");
		gaim.setUsername("fred");
		
		Manager.processMessage(gaim);
		
	}
	
	String url;
	int port;
	
	
	
	public void setUrl(String url) {
		this.url = url;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getURL(){
            return url;//"129.219.36.173";
	}
	
	public int getPort(){
		return port;
	}
	
	public Message sendMessage(Message message){
		
		Message reply = null;
		
		try {
			//connect to the server
			System.out.println("Connecting... URL: " + url + ", Port: " + port);
			Socket senderSocket = new Socket(getURL(), getPort());
			System.out.println("Connected.");
			
			//this is the stream that goes TO the server
			PrintWriter out = new PrintWriter(senderSocket.getOutputStream(), true);
			//this is the stream that comes FROM the server
			BufferedReader in = new BufferedReader(new InputStreamReader(
			                            senderSocket.getInputStream()));

			//write a message to the server
			Gson gson = new Gson();
			System.out.println("Message class: " + message.getClass().getCanonicalName());
			String json = gson.toJson(message, message.getClass());
			json = message.getClass().getCanonicalName() + ";" + json;
			System.out.println("Sending: " + json);
			
			out.write(json + "\n");//without '\n' the server won't know the message has terminated
			out.flush(); // deadly important.
			
			//get a message from the server
			String line = in.readLine();
			System.out.println("Here is the line: " + line);
			String[] parts = line.split(";");
			
			try{
				reply = (Message) gson.fromJson(parts[1], Class.forName(parts[0]));
			}catch(Exception ex){
				System.out.println("Here is the error.");
				ex.printStackTrace();
			}
			
			//close the connection
			senderSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reply;
		
	}
}
