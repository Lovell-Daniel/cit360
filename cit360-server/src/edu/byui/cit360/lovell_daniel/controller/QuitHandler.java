package edu.byui.cit360.lovell_daniel.controller;

import edu.byui.cit360.lovell_daniel.view.View;

public class QuitHandler extends Handler {
	@Override
	void handleIt() {
		String message = "\nHaven't figured out how to quit yet, sorry."
						+"\nmenu=return to menu"
						+"\n\nEnter Command : ";
		
		View view = new View();
		view.display(message);
	}
}
