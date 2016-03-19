package edu.byui.cit360.lovell_daniel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SearchHandler extends Handler {

	@Override
	void handleIt() {
		/* SearchYelp search = new SearchYelp();
		 * ResultsToServer toServer = new ResultsToServer();
		 * * Connection connection = new Connection();
		 * * save to server
		 * display results
		 * * with return to menu
		*/
		System.out.println("Search Yelp stub");
		
		//try (Socket sock =  new Socket(InetAddress.getByName(null), 4499, null, 0);
		try (Socket sock =  new Socket(InetAddress.getByName(null), 4499);
				BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
				PrintWriter out = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
				) {
			out.print("test");
		} catch (IOException e) {
			System.out.println("\n**ERROR** There was a problem connecting to the server.");
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
