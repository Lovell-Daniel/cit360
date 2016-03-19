package edu.byui.cit360.lovell_daniel.controller;

import edu.byui.cit360.lovell_daniel.view.View;

public class MenuHandler extends Handler {
	@Override
	void handleIt() {
		String message = "\nsearch=search Yelp"
						+"\nhelp=help menu"
						+"\nquit=quit application"
						+"\n\nEnter Command : ";
		
		View view = new View();
		view.display(message);
	}
}
