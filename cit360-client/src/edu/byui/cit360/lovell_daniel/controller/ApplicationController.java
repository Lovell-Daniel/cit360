package edu.byui.cit360.lovell_daniel.controller;

public class ApplicationController {

	public void handleRequest(String request, String...strings) {
		HandlerMap map = new HandlerMap();
		Handler handler = map.getHandler(request);
		handler.handleIt();
	}
}
