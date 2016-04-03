package edu.byui.cit360.lovell_daniel.model;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class DummyData {
	
	public HashSet<User> createDummyData() {
		ZonedDateTime time1a = ZonedDateTime.now();
		ZonedDateTime time1b = ZonedDateTime.now();
		ZonedDateTime time1c = ZonedDateTime.now();
		ZonedDateTime time2a = ZonedDateTime.now();
		ZonedDateTime time2b = ZonedDateTime.now();
		ZonedDateTime time2c = ZonedDateTime.now();
		String sampleJSON = "{sample}";
		YelpResponse response1a = new YelpResponse(time1a, sampleJSON);
		YelpResponse response1b = new YelpResponse(time1b, sampleJSON);
		YelpResponse response1c = new YelpResponse(time1c, sampleJSON);
		YelpResponse response2a = new YelpResponse(time2a, sampleJSON);
		YelpResponse response2b = new YelpResponse(time2b, sampleJSON);
		YelpResponse response2c = new YelpResponse(time2c, sampleJSON);
		YelpResponse[] responses1 = {response1a, response1b, response1c};
		YelpResponse[] responses2 = {response2a, response2b, response2c};
		ArrayList<YelpResponse> lastThree1 = new ArrayList<>(3);
		ArrayList<YelpResponse> lastThree2 = new ArrayList<>(3);
		for (YelpResponse response: responses1) {
			lastThree1.add(response);
		}
		for (YelpResponse response: responses2) {
			lastThree2.add(response);
		}
		String user1 = "Daniel";
		String user2 = "Nicole";
		HashSet<User> users = new HashSet<>(2);
		users.add(new User(user1, lastThree1));
		users.add(new User(user2, lastThree2));
		printDummyData(users);
		return users;
	}
	
	private void printDummyData(HashSet<User> users) {
		for (User user: users) {
			System.out.println(user.getName());
			Iterator<YelpResponse> iterResponses = user.getResponses().iterator();
			while (iterResponses.hasNext()) {
				YelpResponse response = iterResponses.next();
				System.out.println(response.getTime().toString());
				System.out.println(response.getJson());
			}
		}
	}
}
