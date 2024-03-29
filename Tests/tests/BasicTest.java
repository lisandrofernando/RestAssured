package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import files.PayLoad;
import files.ReUsableMethods;
import files.URI;

/*
 * This is a basic test that obeys the following pattern:
 * given -All input details
 * when  - submit the API -resource, http method
 * Then  -Validate the response
 * There is a way to send the Json body from a file in the computer with a method that converts the file into bytes
 * The ways it is done=> Files.readAllBytes(Paths.get()) 
 * Jira is a software management tool which many companies use to track their project.
 * HTTP response status codes are: Information Responses:100 continue, 101 Switching Protocols, 102 Processing, 103 Early Hints
 * Successful responses 200 OK, 201 Created, Redirections: 300 Multiple Choice, 301 moved permanently
 * Client Error Responses: 400 Bad Request, 401 Unauthorized, 403 forbidden, 404 Not Found
 * Server error responses: 500 Internal server error, 502 Bad Gateway, 504 Gateway Timeout 
 * Types of authentications: Basic Authentications, Jira Cookie Based Authentication and OAuth 2.0
 * The OAuth based authentication is devided in two Grant Types: Authorization Code, Client credentials
 * The OAuth authentication means integration with facebook or google and no data breach problems which is safe navigation
 * First in OAuth GetAuthorization Code Request, Get Access Token Request
 * Serialization in Rest Assured Context is a process of Converting Java object into a request body
 * Deserialization by converting Response body back to Java object
 * Test case design techniques are: Error Guessing, Boundary value Analysis, Decision Table Techniques
 * State transition Techniques and Equivalence Partitioning. 
 * GraphQL in a practical sense can avoid over feching or under feching and performance issues in the application. GraphQL is a query language
 * and server-side runtime to fulfill those queries on your existing data. In GraphQL there are three things to understand: Types. 
 */

public class BasicTest {
	static String response;
    static String placeID;
	static String Address = "San Pedro Area";
	static String getPlaceResponse;

	@BeforeTest
	public void postTest() {

		URI.uri();
		response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(PayLoad.AddPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat()
				.statusCode(200).body("scope", equalTo("APP")).extract().response().asString();

		JsonPath js = ReUsableMethods.rowToJson(response);
		placeID = js.getString("place_id");
		System.out.println(placeID);
	}
	
	
	@AfterTest
	   public void getTest() {
		  URI.uri();
			response = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).when()
					.get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200).extract().response()
					.asString();
			System.out.println("The GET Response is: "+response);

		}
  @Test	
  public void updateTest() {
	  URI.uri();
		String getUpdateResponse = given().log().all().queryParam("key", "qaclick123")
				.header("Content-Type", "application/json").body(PayLoad.UpadatePlace(placeID, Address)).when()
				.put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated")).extract().response().asString();
		JsonPath jsi = ReUsableMethods.rowToJson(getUpdateResponse);
		String updatedAddress = jsi.getString("address");
		System.out.println("The updated response is here:  " + updatedAddress);
	    //Assert.assertEquals(updatedAddress, Address);
}
  
}
