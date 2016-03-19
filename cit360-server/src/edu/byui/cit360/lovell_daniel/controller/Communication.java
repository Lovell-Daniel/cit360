package edu.byui.cit360.lovell_daniel.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communication implements Runnable {
	
	private Socket connection;
	
	public Communication(Socket connection) {
		this.connection = connection;
	}
	
	public void run() {
		
		try (
			PrintWriter toClient = new PrintWriter(connection.getOutputStream(), true);
			BufferedReader fromClient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		) {		            
		    //out.print("JSON?");
		    
		    String line;
		    StringBuilder sb = new StringBuilder();
		    while ((line = fromClient.readLine()) != null) {
				sb.append(line);
				System.out.println(line);
		    }
		} catch (Exception e) {
			System.out.println("\n**ERROR** There was a problem communicating with a client.");
			System.out.println(e.getMessage());
			e.printStackTrace();
	    }
	}
}
