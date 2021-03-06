package tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
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
 */

public class BuildRequestSpec {
	
	String placeID;
	String newAddress="Paseo Ecatepec 514-A, Mexico";
	String getPlaceResponse;
	
@Test	
 public void postTest() {
	
	RequestSpecification req = new RequestSpecBuilder().setBaseUri(URI.uri()).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
	ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	RequestSpecification res = given().spec(req)
	 .body(PayLoad.AddPlace());
	 Response response = res.when().post("maps/api/place/add/json").then().spec(resspec)
	.extract().response();
	String responseString = response.asString();
      System.out.println(responseString);
	
   }
//@Test
 public void updateTest() {
	 URI.uri();
	getPlaceResponse =   given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	 .body("{\n"
	 		+ "\"place_id\":\""+placeID+"\",\n"
	 		+ "\"address\":\""+newAddress+"\",\n"
	 		+ "\"key\":\"qaclick123\"\n"
	 		+ "}").when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
	 .body("msg", equalTo("Address successfully updated")).extract().response().asString();
	   JsonPath js = new JsonPath(getPlaceResponse);
		 String actualAddress = js.getString("address");
		 System.out.println(actualAddress);	
		 //Assert.assertEquals(actualAddress, newAddress);
	
  }
//@Test
public void getPlace() {
	URI.uri();
	 getPlaceResponse =  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
	 .when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
	 .extract().response().asString();
	
  }
}
