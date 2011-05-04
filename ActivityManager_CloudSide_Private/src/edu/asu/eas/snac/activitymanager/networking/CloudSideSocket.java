package edu.asu.eas.snac.activitymanager.networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import edu.asu.eas.snac.activitymanager.messages.FeedbackMessage;
import edu.asu.eas.snac.activitymanager.messages.FeedbackType;
import edu.asu.eas.snac.activitymanager.messages.Message;

public class CloudSideSocket {

	private ServerSocket serverSocket;
	private Socket clientSocket;
	private boolean kill;

	public CloudSideSocket(int port) {
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		kill = false;
	}

	public void connect() {
		while(!kill){
			try {
				//set up the client to wait for a message
				System.out.println("Waiting for a pair.");
				clientSocket = serverSocket.accept();
				System.out.println("Found a pair.");
	
				//this is the stream to send messages TO a client
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				//this is the stream to read messages FROM a client
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println("Found the in/out streams.");
				String object = in.readLine();
				System.out.println("Read the data.");
				System.out.println("The data is: " + object);
				String[] objectInfo = object.split(";");
				
				Gson gson = new Gson();
				
				Message m = null;
				
				//unmarshall the object
				try {
					System.out.println(object);
					m = (Message) gson.fromJson(objectInfo[1], Class.forName(objectInfo[0]));
				} catch (JsonParseException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				//process the message
				Message fbm = new FeedbackMessage();
				fbm.setMsgType(FeedbackType.SUCCESS * -1);
				try{
					fbm = ProcessMessageDirector.processMessage(m);
				}catch(Exception ex){
					System.out.println("Holy moly! An Exception");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
					ex.printStackTrace();
				}
				//marshall the response
				object = fbm.getClass().getCanonicalName() + ";" + gson.toJson(fbm, fbm.getClass()); 
				
				//send a response to the caller
				System.out.println("Here is my response: " + object);
				out.write(object + "\n");
				out.flush();
				
				//close the connection with this client
				clientSocket.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void close(){
		kill = true;
	}
}
