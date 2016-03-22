package edu.byui.cit360.lovell_daniel.controller;

import java.util.ArrayList;

import edu.byui.cit360.lovell_daniel.view.View;

public class HelpHandler extends Handler {
	@Override
	String handleIt(ArrayList<String> data) {
		String message = "\nConsider yourself helped."
						+"\nmenu=return to menu"
						+"\n\nEnter Command : ";

		View view = new View();
		view.display(message);
		return "";
	}
}
