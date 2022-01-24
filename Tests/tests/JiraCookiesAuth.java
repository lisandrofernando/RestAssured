package tests;

import org.testng.annotations.Test;

import files.PayLoad;
import files.URI;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

public class JiraCookiesAuth {

	SessionFilter filter;
	
	@Test
	public void jiraAuthentication() {
	 filter = new SessionFilter();
		URI.jiraURI();
		String response =given().log().all().header("Content-Type","application/json")
		.body(PayLoad.jiraCookieAuth("lisandrusfernandus", "Lisandro100Q")).filter(filter)
		.when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
		
		given().pathParam("id", "10003").header("Content-Type", "application/json")
		.body(PayLoad.addCommentJira("Adding from eclipse with love")).filter(filter)
		.when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201);
	}
	
	//@Test
	public void creatingIssue() {
		
		URI.jiraURI();
		
		given().log().all().header("Content-Type","application/json")
		.header("Cookie","JSESSIONID=2AD2C958A28226613804E8DD8BA37523")
		.body(PayLoad.createIssueJira("Eclipse Issue", "Second Issue")).filter(filter)
		.when().post("/api/2/issue").then().log().all().assertThat().statusCode(201);
	}
	//@Test
	public void creatingCommentJira() {
		given().pathParam("id", "10003").header("Content-Type", "application/json")
		.body(PayLoad.addCommentJira("Adding from eclipse")).filter(filter)
		.when().post("/rest/api/2/issue/{id}/comment").then().log().all().assertThat().statusCode(201);
	}
}
