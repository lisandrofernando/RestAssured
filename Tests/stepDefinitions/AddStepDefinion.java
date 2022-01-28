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
import resources.Utils;

public class AddStepDefinion extends Utils{


	RequestSpecification res;
	Response response;
	
	@Given("^Add Place Payload$")
    public void add_place_payload() throws Throwable {
		
		
         res = given().spec(RequestSpecification())
		 .body(PayLoad.AddPlace());
    }

    @When("^user calls \"([^\"]*)\" with Post http request$")
    public void user_calls_something_with_post_http_request(String strArg1) throws Throwable {
    	  response = res.when().post("maps/api/place/add/json").then().spec(ResponseSpecification())
    				.extract().response();
    }

    @Then("^the API call is successlly with status code 200$")
    public void the_api_call_is_successlly_with_status_code_200() throws Throwable {
          assertEquals(response.getStatusCode(),200);
    }

    @And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
    public void something_in_response_body_is_something(String key, String value) throws Throwable {
    	String responseString = response.asString();
        JsonPath js = new JsonPath(responseString);
       assertEquals(js.get(key).toString(),value);
       
    }
}
