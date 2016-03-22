package edu.byui.cit360.lovell_daniel.controller;

import java.util.HashMap;

public class HandlerMap {
	private HashMap<String, Handler> map = new HashMap<>();
	
	public HandlerMap() {
		//populate the map with messages for the view
		map.put("menu", new MenuHandler());
		map.put("start", new StartHandler());
		map.put("stop", new StopHandler());
		map.put("help", new HelpHandler());
		map.put("quit", new QuitHandler());
		
		//populate the map with messages for the server
		map.put("newUser", new NewUserHandler());
		map.put("response", new ResponseHandler());
		map.put("last3", new Last3Handler());
	}

	public Handler getHandler(String request) {
		return map.get(request);
	}
	
	public boolean isValidRequest(String request) {
		return map.containsKey(request);
	}
}
