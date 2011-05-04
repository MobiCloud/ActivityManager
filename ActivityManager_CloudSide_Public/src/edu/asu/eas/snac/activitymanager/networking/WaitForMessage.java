package edu.asu.eas.snac.activitymanager.networking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WaitForMessage {
	public static void main(String[] args) throws InterruptedException {
		//get the port from the first argument
		int port;
		try{
			port = Integer.parseInt(args[0]);
		}
		catch(ArrayIndexOutOfBoundsException ex){
			port = 1337;
		}
		
		ServerRunner t = new ServerRunner(port);
		
		t.start();
		
		System.out.println("I'm a public server LOL!");
		System.out.println("Listening on port: " + port);
		System.out.println("Enter \"kill\" to kill the server.");
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			while(!(in.readLine()).equals("kill")){}
			System.out.println("The server will die after the next message.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			t.close();
			t.join();
		}
	}
}
