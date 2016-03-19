package edu.byui.cit360.lovell_daniel.controller;

import java.util.HashMap;

public class HandlerMap {
	private HashMap<String, Handler> map = new HashMap<>();
	
	public HandlerMap() {
		//populate the map with messages for the view
		map.put("menu", new MenuHandler());
		map.put("search", new SearchHandler());
		map.put("help", new HelpHandler());
		map.put("quit", new QuitHandler());
	}

	public Handler getHandler(String request) {
		return map.get(request);
	}
}
