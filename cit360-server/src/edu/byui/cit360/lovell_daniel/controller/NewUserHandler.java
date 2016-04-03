package edu.byui.cit360.lovell_daniel.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.hibernate.Session;

import edu.byui.cit360.lovell_daniel.model.DummyData;
import edu.byui.cit360.lovell_daniel.model.User;

public class NewUserHandler extends Handler {

	@Override
	String handleIt(ArrayList<String> data) {
		/*
		//create database session
		Session session = HibernateUtility.getSessionFactory().openSession();
		User user  = new User();

		*/
		
		//get name from data
		String name = data.get(0);
		
		
		
		//Create dummy data -  REPLACE with query database when available
		DummyData dummydata = new DummyData();
		HashSet<User> users = dummydata.createDummyData();
		
		
		//Check if name already exists
		Boolean nameExists = null;
		for (User user : users) {
			nameExists = user.getName().equals(name);
			if (nameExists) {
				//return error
				System.out.println("User already exists");
				return "userExists";
			} else {
				continue;
			}
		}
		
		
		//create user
		users.add(new User(name));
		System.out.println("Created user: "+name);
		return "success";
		
	}
}
