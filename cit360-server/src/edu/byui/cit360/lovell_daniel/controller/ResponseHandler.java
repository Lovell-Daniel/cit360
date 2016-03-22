package edu.byui.cit360.lovell_daniel.controller;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import edu.byui.cit360.lovell_daniel.model.DummyData;
import edu.byui.cit360.lovell_daniel.model.User;
import edu.byui.cit360.lovell_daniel.model.YelpResponse;

public class ResponseHandler extends Handler {

	@Override
	String handleIt(ArrayList<String> data) {
		//get response from data
		String name = data.get(0);
		String response = data.get(1);
		
		//Create dummy data -  REPLACE with query database when available?
		DummyData dummydata = new DummyData();
		HashSet<User> users = dummydata.createDummyData();
		
		//Check if name already exists - will be replaced with database query?
		Boolean nameExists = null;
		for (User user : users) {
			nameExists = user.getName().equals(name);
			if (nameExists) {
				System.out.println(name+" authenticated");
				user.getResponses().add(new YelpResponse(ZonedDateTime.now(), response));
				System.out.println("Added response for "+name);
				return "success";
			} else {
				continue;
			}
		}
		System.out.println(name+" does not exist");
		return "!userExists";
	}

}
