package edu.byui.cit360.lovell_daniel.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import edu.byui.cit360.lovell_daniel.controller.ApplicationController;

public class View {
	PrintWriter console = new PrintWriter(System.out, true);
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	//View object is activated by calling display() with a message.
	//If additional data is needed then messages[] will ask for it.
	public void display(String message, String...messages) {
		boolean repeat;
		String request;
		ArrayList<String> data = new ArrayList<>(0);
		ApplicationController appController = new ApplicationController();
		
		do {
			//print the message to the console
			console.println(message);
			//wait for input
			request = getInput();
			//check if added data is needed
			if (messages.length != 0) {
				for (String m : messages) {
					//print additional message
					console.println(m);
					//get additional data
					data.add(getInput());
				}
			}
			//send request to controller
			String valid = appController.handleRequest(request, data);
			if (valid.equals("invalid")) {
				console.print("\n***ERROR: Invalid request. Try Again.***\n");
				repeat = true;
			} else {
				repeat = false;
			}
		} while (repeat);
	}
	
	
	public String getInput() {
		String choice = null;
		//repeats until something is entered
		do {
			try {
				choice = keyboard.readLine();//waits for entry
				choice = choice.trim().toLowerCase();//cleans entry
			} catch (IOException e) {
				console.println("\nThere was a problem getting your input. ");
				console.println(e.getMessage());
				e.printStackTrace();
			}
		} while (choice == null || choice.isEmpty());//repeats until something is entered
		return choice;
	}
	
}
