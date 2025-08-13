package com.qa.api.amedus;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;



public class roughh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * String response = "{\"fields_and_error_codes\": \"{'name': ['blank']}\"}";
		 * 
		 * JsonPath path = new JsonPath(response);
		 * 
		 * String str = path.getString("fields_and_error_codes");
		 * 
		 * System.out.println(str);
		 * 
		 * str = str.replace("'", "\""); str = str.replace("]", ""); str =
		 * str.replace("[", ""); str = str.replace("}", ""); str = str.replace("{", "");
		 * 
		 * System.out.println(str); Map<String, String> map = new HashMap<String,
		 * String>();
		 * 
		 * String[] str1 = str.split(":");
		 * 
		 * System.out.println(Arrays.toString(str1));
		 * 
		 * map.put(str1[0], str1[1]);
		 */
	/*	
	      String json = "{\"fields_and_error_codes\": \"{'name': ['blank']}\"}";

	        String value = JsonPath
	                .parse(json)      // fix single quotes
	                .read("$.fields_and_error_codes", String.class); // read inner string
	                //.replace("'", "\"");                 // fix inner JSON quotes again
	        
	        System.out.println(value);

	        String result = JsonPath.parse(value).read("$.name[0]");
	        System.out.println(result); // blank
	    }*/
		
		
		  String json = "[\n" +
	                "  {\n" +
	                "    \"category\": \"fiction\",\n" +
	                "    \"author\": \"George Orwell\",\n" +
	                "    \"title\": \"1984\",\n" +
	                "    \"price\": 8.99\n" +
	                "  },\n" +
	                "  {\n" +
	                "    \"category\": \"fiction\",\n" +
	                "    \"author\": \"J.K. Rowling\",\n" +
	                "    \"title\": \"Harry Potter\",\n" +
	                "    \"price\": 12.99\n" +
	                "  },\n" +
	                "  {\n" +
	                "    \"category\": \"non-fiction\",\n" +
	                "    \"author\": \"Yuval Noah Harari\",\n" +
	                "    \"title\": \"Sapiens\",\n" +
	                "    \"price\": 15.99\n" +
	                "  }\n" +
	                "]";

	        // Parse JSON array into List of Maps
	        List<Map<String, Object>> books = JsonPath.read(json, "$");
	        
	        
	        System.out.println(books);
		
	        
	        
	        
	        String json1 = "[\n"
	        		+ "  \"97563c9d-c11b-4bae-a2fd-79cfe0e4e7d3\",\n"
	        		+ "  \"8b5a7b09-c7bd-45c0-9161-2b2445f6c954\",\n"
	        		+ "  \"06dfd862-a60a-4022-8d95-6d0e3a71b2dd\"\n"
	        		+ "]";
	        
	
	     List <String> json1_lst =   JsonPath.read(json1, "$");
	     System.out.println(json1_lst);
	        
	     
	     
		
	}
	

}
		
	


