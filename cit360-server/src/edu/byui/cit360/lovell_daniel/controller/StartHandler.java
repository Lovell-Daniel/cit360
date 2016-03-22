package edu.byui.cit360.lovell_daniel.controller;

import java.util.ArrayList;

public class StartHandler extends Handler {

	@Override
	String handleIt(ArrayList<String> data) {
		//Start server in new thread
		StartServer startServer = new StartServer();
		new Thread(startServer).start();
		//
		ApplicationController appController = new ApplicationController();
		appController.handleRequest("menu", new ArrayList<String>(0));
		return "";
	}

}
