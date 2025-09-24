package com.qa.api.amedus;

import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
		 * String json = "{\"fields_and_error_codes\": \"{'name': ['blank']}\"}";
		 * 
		 * String value = JsonPath .parse(json) // fix single quotes
		 * .read("$.fields_and_error_codes", String.class); // read inner string
		 * //.replace("'", "\""); // fix inner JSON quotes again
		 * 
		 * System.out.println(value);
		 * 
		 * String result = JsonPath.parse(value).read("$.name[0]");
		 * System.out.println(result); // blank
		 * 
		 * 
		 * 
		 * String json2 = "[\n" + "  {\n" + "    \"category\": \"fiction\",\n" +
		 * "    \"author\": \"George Orwell\",\n" + "    \"title\": \"1984\",\n" +
		 * "    \"price\": 8.99\n" + "  },\n" + "  {\n" +
		 * "    \"category\": \"fiction\",\n" + "    \"author\": \"J.K. Rowling\",\n" +
		 * "    \"title\": \"Harry Potter\",\n" + "    \"price\": 12.99\n" + "  },\n" +
		 * "  {\n" + "    \"category\": \"non-fiction\",\n" +
		 * "    \"author\": \"Yuval Noah Harari\",\n" + "    \"title\": \"Sapiens\",\n"
		 * + "    \"price\": 15.99\n" + "  }\n" + "]";
		 * 
		 * // Parse JSON array into List of Maps List<Map<String, Object>> books =
		 * JsonPath.read(json2, "$");
		 * 
		 * 
		 * System.out.println(books);
		 * 
		 * 
		 * 
		 * 
		 * String json1 = "[\n" + "  \"97563c9d-c11b-4bae-a2fd-79cfe0e4e7d3\",\n" +
		 * "  \"8b5a7b09-c7bd-45c0-9161-2b2445f6c954\",\n" +
		 * "  \"06dfd862-a60a-4022-8d95-6d0e3a71b2dd\"\n" + "]";
		 * 
		 * 
		 * List <String> json1_lst = JsonPath.read(json1, "$");
		 * System.out.println(json1_lst);
		 * 
		 * 
		 * 
		 * 
		 * }
		 */

		String jsontest = "{\n" + "    \"count\": 11,\n"
				+ "    \"next\": \"https://dev-vm-test-tc3-04/api/fleet/v2/maps/?limit=3&offset=3&page=1\",\n"
				+ "    \"previous\": null,\n" + "    \"results\": [\n" + "        {\n"
				+ "            \"id\": \"97563c9d-c11b-4bae-a2fd-79cfe0e4e7d3\",\n"
				+ "            \"last_modified\": \"2025-08-07T19:30:48.501356Z\",\n"
				+ "            \"created\": \"2025-08-07T19:18:53.843595Z\",\n"
				+ "            \"name\": \"TC3-copy\",\n" + "            \"description\": \"\",\n"
				+ "            \"project\": null,\n" + "            \"tag\": null,\n"
				+ "            \"cached\": true,\n" + "            \"disabled\": false,\n"
				+ "            \"user_id\": \"administrator\",\n" + "            \"author\": null,\n"
				+ "            \"revision\": 7,\n" + "            \"tag_index\": 1,\n"
				+ "            \"source_map\": \"4f28649d-9547-49e0-8c76-4ba546cbbb97\"\n" + "        },\n"
				+ "        {\n" + "            \"id\": \"8b5a7b09-c7bd-45c0-9161-2b2445f6c954\",\n"
				+ "            \"last_modified\": \"2025-08-07T19:19:05.723634Z\",\n"
				+ "            \"created\": \"2025-08-07T19:19:05.122422Z\",\n"
				+ "            \"name\": \"TC3-copy\",\n" + "            \"description\": \"\",\n"
				+ "            \"project\": null,\n"
				+ "            \"tag\": \"8b5a7b09-c7bd-45c0-9161-2b2445f6c954\",\n" + "            \"cached\": true,\n"
				+ "            \"disabled\": false,\n" + "            \"user_id\": \"administrator\",\n"
				+ "            \"author\": \"administrator\",\n" + "            \"revision\": 1,\n"
				+ "            \"tag_index\": 1,\n"
				+ "            \"source_map\": \"97563c9d-c11b-4bae-a2fd-79cfe0e4e7d3\"\n" + "        },\n"
				+ "        {\n" + "            \"id\": \"06dfd862-a60a-4022-8d95-6d0e3a71b2dd\",\n"
				+ "            \"last_modified\": \"2025-08-07T19:17:33.726458Z\",\n"
				+ "            \"created\": \"2025-08-07T13:44:14.028374Z\",\n" + "            \"name\": \"TC3\",\n"
				+ "            \"description\": \"\",\n" + "            \"project\": null,\n"
				+ "            \"tag\": null,\n" + "            \"cached\": true,\n"
				+ "            \"disabled\": false,\n" + "            \"user_id\": \"administrator\",\n"
				+ "            \"author\": null,\n" + "            \"revision\": 19,\n"
				+ "            \"tag_index\": 4,\n" + "            \"source_map\": null\n" + "        }\n" + "    ]\n"
				+ "}";

		List<String> idname = JsonPath.read(jsontest, "$.results[*].id");

		for (String ele : idname) {
			System.out.println(ele);
		}

		List<Map<String, String>> id_name = JsonPath.read(jsontest, "$.results[*]['id','name']");

		for (Map<String, String> ele : id_name) {
			// System.out.println(ele.get("id"));
			// System.out.println(ele.get("name"));

		}

		for (int i = 0; i < id_name.size(); i++) {
			System.out.println("ID of the map  " + id_name.get(i).get("id"));
			System.out.println("Name of the map  " + id_name.get(i).get("name"));
		}

	}

}
