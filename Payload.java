package com.project;

public class Payload {

	public static String getAccountInfo() { 
		 return "{\r\n" + 
		 		"    \"username\": \"jpawar2303\",\r\n" + 
		 		"    \"password\": \"test12345\"\r\n" + 
		 		"}";
		 }
	
	public static String getTaskIssue() { 
		 return " {\r\n" + 
		 		"    \"fields\": {\r\n" + 
		 		"       \"project\":\r\n" + 
		 		"       {\r\n" + 
		 		"          \"key\": \"FIR\"\r\n" + 
		 		"       },\r\n" + 
		 		"       \"summary\": \"Create new record\",\r\n" + 
		 		"       \"description\": \"adding new employee record\",\r\n" + 
		 		"       \"issuetype\": {\r\n" + 
		 		"          \"name\": \"Task\"\r\n" + 
		 		"       }\r\n" + 
		 		"   }\r\n" + 
		 		"}";
	 }
	
	public static String getFeatureIssue() { 
		 return " {\r\n" + 
		 		"    \"fields\": {\r\n" + 
		 		"       \"project\":\r\n" + 
		 		"       {\r\n" + 
		 		"          \"key\": \"%s\"\r\n" + 
		 		"       },\r\n" + 
		 		"       \"summary\": \"%s\",\r\n" + 
		 		"       \"description\": \"%s\",\r\n" + 
		 		"       \"issuetype\": {\r\n" + 
		 		"          \"name\": \"%s\"\r\n" + 
		 		"       }\r\n" + 
		 		"   }\r\n" + 
		 		"}";
	 }
	
	
	
}
