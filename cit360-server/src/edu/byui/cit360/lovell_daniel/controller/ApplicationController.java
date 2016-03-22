package edu.byui.cit360.lovell_daniel.controller;

import java.util.ArrayList;

public class ApplicationController {

	public String handleRequest(String request, ArrayList<String> data) {
		HandlerMap map = new HandlerMap();
		if (map.isValidRequest(request)) {
			Handler handler = map.getHandler(request);
			String result;
			result = handler.handleIt(data);
			return result;
		} else {
			return "invalid";
		}
	}
}
