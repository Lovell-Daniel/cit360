package edu.byui.cit360.lovell_daniel.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import edu.byui.cit360.lovell_daniel.view.ServerView;

public class StartServer implements Runnable {

	@Override
	public void run() {
		boolean quitServer = false;
		while(!quitServer) {
			try (ServerSocket serverSocket = new ServerSocket(4499);){
				try {
					System.out.println("Server accepting new connections.");
					Socket clientSocket = serverSocket.accept();
					System.out.println("Client connected from: "+clientSocket.getInetAddress());
					ServerView communication = new ServerView(clientSocket);
					new Thread(communication).start();
				} catch (IOException e){
					System.out.println("\n**ERROR** There was a problem connecting with client.");
					System.out.println(e.getMessage());
					e.printStackTrace();
				}
			} catch (IOException e) {
				System.out.println("\n**ERROR** There was a problem starting the server.");
				System.out.println(e.getMessage());
				e.printStackTrace();
				quitServer = true;
			}
		}		
	}
}
