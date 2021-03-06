package edu.byui.cit360.lovell_daniel.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

public class YelpResponse implements Serializable{

	private int id;
	private ZonedDateTime time;
	private String json;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ZonedDateTime getTime() {
		return time;
	}

	public void setTime(ZonedDateTime time) {
		this.time = time;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public YelpResponse() {
	}
	
	public YelpResponse(ZonedDateTime time, String json) {
		this.json = json;
		this.time = time;
	}
	
}
