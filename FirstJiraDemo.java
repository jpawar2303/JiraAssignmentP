package com.project;

import static io.restassured.RestAssured.given;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;

public class FirstJiraDemo {

	public static final String CREATE_ACCOUNT_URI="rest/auth/1/session";
	public static final String CREATE_ISSUE_URI="rest/api/2/issue";

	@Test
	public void testCase() throws IOException{
		// TODO Auto-generated method stub

		RestAssured.baseURI="http://localhost:8090";
		
		String actualBody = String.format(Payload.getAccountInfo());


		SessionFilter sf = new SessionFilter();
		
		given().log().all().contentType(ContentType.JSON)
		.body(actualBody).log().all()
		.filter(sf)
		.when()
		.post(CREATE_ACCOUNT_URI)
		.then().log().all()
		.assertThat()
		.statusCode(200);
		
		
		//Bug 
		String s = generateStringFromFile("src/main/resources/createToken.json");
		String issueBody = String.format(s);
		
		given().log().all().contentType(ContentType.JSON)
		.body(issueBody).log().all()
		.filter(sf)
		.when()
		.post(CREATE_ISSUE_URI)
		.then().log().all()
		.assertThat()
		.statusCode(201);
		
		//Task
		
		//String s = generateStringFromFile("src/main/resources/taskToken.json");
		//String taskBody = String.format(s);

		String taskBody = String.format(Payload.getTaskIssue());
				
		given().log().all().contentType(ContentType.JSON)
		.body(taskBody).log().all()
		.filter(sf)
		.when()
		.post(CREATE_ISSUE_URI)
		.then().log().all()
		.assertThat()
		.statusCode(201);
		
		//New Feature
		
		//String s = generateStringFromFile("src/main/resources/newFeatureToken.json");
		//String storyBody = String.format(s);
		
		String storyBody = String.format(Payload.getFeatureIssue(),"FIR","create new feature","Assign this to developer","New Feature");
		
		given().log().all().contentType(ContentType.JSON)
		.body(storyBody).log().all()
		.filter(sf)
		.when()
		.post(CREATE_ISSUE_URI)
		.then().log().all()
		.assertThat()
		.statusCode(201);
		
	}
	
	public static String generateStringFromFile(String path) throws IOException {
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
