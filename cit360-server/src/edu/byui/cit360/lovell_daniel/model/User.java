package edu.byui.cit360.lovell_daniel.model;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
	
	private int id;
	private String name;
	private ArrayList<YelpResponse> responses;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<YelpResponse> getResponses() {
		return responses;
	}

	public void setLastThree(ArrayList<YelpResponse> responses) {
		this.responses = responses;
	}
	
	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}

	public User(String name, ArrayList<YelpResponse> responses) {
		this.name = name;
		this.responses = responses;
	}
	
}
