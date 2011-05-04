package edu.asu.eas.snac.activitymanager.networking;

public class ServerRunner extends Thread{

	private int port;
	private CloudSideSocket css;
	
	public ServerRunner(int port){
		this.port = port;
	}
	
	public void run() {
		css = new CloudSideSocket(port);
		css.connect();
	}
	
	public void close(){
		css.close();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
}
