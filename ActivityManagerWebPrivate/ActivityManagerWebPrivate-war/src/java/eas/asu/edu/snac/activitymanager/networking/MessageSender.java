package eas.asu.edu.snac.activitymanager.networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;
import edu.asu.eas.snac.activitymanager.messages.LoginMessage;
import edu.asu.eas.snac.activitymanager.messages.Message;


public class MessageSender {
	
	
	public static String getURL(){
            return "127.0.0.1";//"129.219.36.173";
	}
	
	public static int getPort(){
		int port = 8507;
		//System.out.println("Connecting on port: " + 8507);
		return port;
	}
	
	public static Message sendMessage(Message message){
		
		Message reply = null;
		
		try {
			//connect to the server
			Socket testSocket = new Socket(getURL(), getPort());
			
			//this is the stream that goes TO the server
			PrintWriter out = new PrintWriter(testSocket.getOutputStream(), true);
			//this is the stream that comes FROM the server
			BufferedReader in = new BufferedReader(new InputStreamReader(
			                            testSocket.getInputStream()));

			//write a message to the server
			Gson gson = new Gson();
			System.out.println("Message class: " + message.getClass().getCanonicalName());
			String json = gson.toJson(message, message.getClass());
			json = message.getClass().getCanonicalName() + ";" + json;
			
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
			testSocket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return reply;
		
	}

        public static void main(String[] args){
            try{
                Gson gson = new Gson();
			Message	reply = (Message) gson.fromJson("{\"wishes\":[{\"sport\":\"Golf\",\"date\":\"12/01/10\",\"starttime\":\"10:00\",\"endtime\":\"5:00\",\"location\":\"Tempe Golf Course\",\"seqNo\":0,\"msgType\":0}],\"seqNo\":0,\"msgType\":0}", Class.forName("edu.asu.eas.snac.activitymanager.messages.WishListMessage"));
			}catch(Exception ex){
				System.out.println("Here is the error.");
				ex.printStackTrace();
			}
        }
}
