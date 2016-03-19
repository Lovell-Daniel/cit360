package edu.byui.cit360.lovell_daniel.controller;

import edu.byui.cit360.lovell_daniel.view.View;

public class StopHandler extends Handler {
	@Override
	void handleIt() {
		String message = "\nHaven't figured out how to stop the server yet, sorry."
						+"\nmenu=return to menu"
						+"\n\nEnter Command : ";
		
		View view = new View();
		view.display(message);
	}
}
