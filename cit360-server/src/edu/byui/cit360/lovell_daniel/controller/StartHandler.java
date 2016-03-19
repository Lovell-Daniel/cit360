package edu.byui.cit360.lovell_daniel.controller;

public class StartHandler extends Handler {

	@Override
	void handleIt() {
		StartServer startServer = new StartServer();
		new Thread(startServer).start();
		ApplicationController appController = new ApplicationController();
		appController.handleRequest("menu");
	}

}
