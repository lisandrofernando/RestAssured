package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;

public class BasicTest {
	String response;
	String placeID;
	String newAddress="Paseo Ecatepec 514-A, Mexico";
	String getPlaceResponse;
	
@Test	
 public void firstTest() {
	 
	 
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	 response =  given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
	 .body(PayLoad.AddPlace()).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
	 .body("scope", equalTo("APP")).extract().response().asString();
	
	JsonPath js = new JsonPath(response);
  placeID=js.getString("place_id");
	System.out.println(placeID);
	
   }
@Test
 public void updateTest() {
	 RestAssured.baseURI= "https://rahulshettyacademy.com";
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
@Test
public void getPlace() {
	RestAssured.baseURI= "https://rahulshettyacademy.com";
	 getPlaceResponse =  given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID)
	 .when().get("maps/api/place/get/json").then().log().all().assertThat().statusCode(200)
	 .extract().response().asString();
	 
	
  }
}
