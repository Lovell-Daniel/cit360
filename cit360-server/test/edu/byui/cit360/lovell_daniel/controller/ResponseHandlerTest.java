package edu.byui.cit360.lovell_daniel.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class ResponseHandlerTest {

	@Test
	public void testHandleIt() {
		// get sample Yelp response
		// eventually I would need to test for different yelp responses
		// for now I am just using a sample response
		String sample = SampleYelp.getSampleYelp();
		
		//populate test cases
		//using an ArrayList of arrays of Strings to allow for easy creation of new test cases
		//each Array of Strings contains a different input with the corresponding expected result
		ArrayList<String[]> tests = new ArrayList<>();
		tests.add(new String[] {"Bob", "!userExists"});
		tests.add(new String[] {"Daniel", "success"});
		tests.add(new String[] {"", "!userExists"});
		
		//test
		for (String[] test : tests) {
			System.out.println("***Test Case:"+test[0]+","+test[1]+"***");
			//establish expected result
			String expResult = test[1];
			//expected result is no longer needed in the array and shouldn't be passed to handleIt()
			//replace the expected result from the array with the sample JSON that is needed for the test
			test[1] = sample;
			//get result from running the test case
			//array needs to be converted to ArrayList before passing it to handleIt
			String result = new ResponseHandler().handleIt(new ArrayList<String> (Arrays.asList(test)));
			assertEquals(expResult, result);
			System.out.println("***Passed***\n");
		}
		
		
		
		
	}

}
