package edu.byui.cit360.lovell_daniel.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.json.JSONArray;

import edu.byui.cit360.lovell_daniel.model.DummyData;
import edu.byui.cit360.lovell_daniel.model.User;
import edu.byui.cit360.lovell_daniel.model.YelpResponse;

public class Last3Handler extends Handler {

	@Override
	String handleIt(ArrayList<String> data) {
		//get response from data
		String name = data.get(0);
		
		//Create dummy data -  REPLACE with query database when available?
		DummyData dummydata = new DummyData();
		HashSet<User> users = dummydata.createDummyData();
		
		//Look for name and get responses
		Boolean nameExists = null;
		for (User user : users) {
			nameExists = user.getName().equals(name);
			if (nameExists) {
				System.out.println(name+" authenticated");
				ArrayList<YelpResponse> responses = user.getResponses();
				JSONArray jsonResponses = new JSONArray(responses); 
				System.out.println("Sent responses for "+name);
				return jsonResponses.toString();
			} else {
				continue;
			}
		}
		System.out.println(name+" does not exist");
		return "!userExists";
	}

}
