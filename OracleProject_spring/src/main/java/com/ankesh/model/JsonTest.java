package com.ankesh.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
public class JsonTest {
	 public static void main( String[] args ) {
		 	List<ZoneCustomerID> a = new ArrayList<>();
		 	Long b = (long)123;
		 	
		 	ZoneCustomerID proj = new ZoneCustomerID(Region.eu_west,b);
	        a.add(proj);
	        a.add(proj);
	        

	        ObjectMapper mapper = new ObjectMapper();
	        String jsonInString = null;
	        try {
				jsonInString = mapper.writeValueAsString(a);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("json is " +jsonInString);
	    }
}
