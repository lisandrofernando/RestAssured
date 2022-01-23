package tests;

import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class JiraCookiesAuth {

	
	@Test
	public void jiraAuthentication() {
		
		RestAssured.baseURI="http://localhost:8080";
		
		String response =given().log().all().header("Content-Type","application/json")
		.body(PayLoad.jiraCookieAuth("lisandrusfernandus", "Lisandro100Q"))
		.when().post("/rest/auth/1/session").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		System.out.println(response);
	}
}
