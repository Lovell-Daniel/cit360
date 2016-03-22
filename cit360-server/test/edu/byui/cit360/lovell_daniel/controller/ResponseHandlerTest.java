package edu.byui.cit360.lovell_daniel.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class ResponseHandlerTest {

	@Test
	public void testHandleIt() {
		
		//populate test cases
		ArrayList<String[]> tests = new ArrayList<>();
		tests.add(new String[] {"Bob", "!userExists"});
		tests.add(new String[] {"Daniel", "success"});
		tests.add(new String[] {"", "!userExists"});
		
		//test
		for (String[] test : tests) {
			System.out.println("***Test Case:"+test[0]+","+test[1]+"***");
			String expResult = test[1];
			String result = new ResponseHandler().handleIt(new ArrayList<String> (Arrays.asList(test)));
			assertEquals(expResult, result);
			System.out.println("***Passed***\n");
		}
		
		
		
		
	}

}
