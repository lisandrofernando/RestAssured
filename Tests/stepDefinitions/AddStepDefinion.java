package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import files.PayLoad;
import files.URI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.TestData;
import resources.Utils;

public class AddStepDefinion extends Utils {

	static RequestSpecification res;
	static Response response;
	static String placeID;
    TestData data = new TestData();
    @Given("^Add Place Payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void add_place_payload_with_something_something_something(String name, String language, String address) throws Throwable {
        
		res = given().spec(RequestSpecification()).body(data.addPlacePojo(name, language,address));
	}

    @When("^user calls \"([^\"]*)\" with \"([^\"]*)\" http request$")
    public static void user_calls_something_with_something_http_request(String resource, String httpMethod) throws Throwable {
       
    
		APIResources resourceAPI =  APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        if(httpMethod.equalsIgnoreCase("POST")) {
		response = res.when().post(resourceAPI.getResource());
        } else if(httpMethod.equalsIgnoreCase("GET")) {
        	response = res.when().post(resourceAPI.getResource());
        }
	}

	@Then("^the API call is successlly with status code 200$")
	public void the_api_call_is_successlly_with_status_code_200() throws Throwable {
		assertEquals(response.getStatusCode(), 200);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String key, String value) throws Throwable {
		
		assertEquals(getJsonPath(response,key), value);

	}
	
	  @And("^verify placeID created maps to \"([^\"]*)\" using \"([^\"]*)\"$")
	    public void verify_placeid_created_maps_to_something_using_something(String expectedName, String resource) throws Throwable {
		  
		   placeID =  getJsonPath(response,"place_id");
		  res = given().spec(RequestSpecification()).queryParam("place_id", placeID);
		  stepDefinitions.AddStepDefinion.user_calls_something_with_something_http_request(resource, "GET");
		  String actualName =  getJsonPath(response,"name");
		  assertEquals(actualName,expectedName);
	    }
	  
	    @Given("^DeletePlace payload$")
	    public void deleteplace_payload() throws Throwable {
	      res= given().spec(RequestSpecification()).body(data.deletePlacePayload(placeID));
	    }
}
