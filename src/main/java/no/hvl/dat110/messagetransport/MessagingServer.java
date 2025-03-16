package no.hvl.dat110.messagetransport;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MessagingServer {

	private ServerSocket welcomeSocket;
	
	public MessagingServer(int port) {
		
		try {
			welcomeSocket = new ServerSocket(port);
		} catch (IOException ex) {
			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	// accept an incoming connection from a client
	public Connection accept () {
		
		Connection connection = null;
		
		// TODO
		// accept TCP connection on welcome socket and create connection
		
		try {
			return new Connection(welcomeSocket.accept());
		} catch (IOException ex) {
			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
			// TODO: closing welcomeSocket
		}
		
		return connection;

	}
	
	public void stop() {
		
		if (welcomeSocket != null) {
			
			try {
			welcomeSocket.close();
			} catch (IOException ex) {
				
			System.out.println("Messaging server: " + ex.getMessage());
			ex.printStackTrace();
		}
		}
	}

}
