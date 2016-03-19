package edu.byui.cit360.lovell_daniel.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import edu.byui.cit360.lovell_daniel.controller.ApplicationController;

public class View {
	PrintWriter console = new PrintWriter(System.out, true);
	BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
	
	//View object is activated by calling display() with a message.
	public void display(String message) {
		String request;
		ApplicationController appController = new ApplicationController();
		
		//print the message to the console
		console.println(message);
		//wait for input
		request = getInput();
		//send request to controller
		appController.handleRequest(request);
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
		} while (choice == "" || choice == null);//repeats until something is entered
		return choice;
	}
	
}
