package edu.byui.cit360.lovell_daniel.controller;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer implements Runnable {

	@Override
	public void run() {
		boolean quitServer = false;
		while(!quitServer) {
			try (ServerSocket serverSocket = new ServerSocket(4499);){
				try {
					Socket clientSocket = serverSocket.accept();
					Communication communication = new Communication(clientSocket);
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
