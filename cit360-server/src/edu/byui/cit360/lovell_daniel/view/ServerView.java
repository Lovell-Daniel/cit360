package edu.byui.cit360.lovell_daniel.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import edu.byui.cit360.lovell_daniel.controller.ApplicationController;

public class ServerView implements Runnable {
	
	private Socket connection;
	
	public ServerView(Socket connection) {
		this.connection = connection;
		
		//create dummy data DELETE after persistence created

	}
	
	public void run() {
		try (
			PrintWriter toClient = new PrintWriter(connection.getOutputStream(), true);
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		) {		            
			//send that server is ready
			toClient.println("ready");
		    
			//wait for and receive request and data
			String request = fromClient.readLine();
			System.out.println("Request from client: "+request);
			ArrayList<String> data = new ArrayList<>(1);
			String line;
			while (!(line = fromClient.readLine()).startsWith("done")) {
				data.add(line);
				System.out.println("Data from client: "+line);
			}
			
			//handle the request
			ApplicationController appController = new ApplicationController();
			String result = appController.handleRequest(request, data);
			if (result == "invalid") System.out.println(result);
			
			//send result to client
			toClient.println(result);
			System.out.println("Client from "+connection.getInetAddress()+" disconnected");
			
		} catch (Exception e) {
			System.out.println("\n**ERROR** There was a problem communicating with a client.");
			System.out.println(e.getMessage());
			e.printStackTrace();
	    }
	}
}
