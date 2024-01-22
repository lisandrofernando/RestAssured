package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.PayLoad;
import files.URI;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class DynamicJson {

/*
 * One of the best ways to handle dynamic Json is to add on Post call and Delete afterwards 
 * To keep running with clean data.
 * An array is a collection of elements
 * Multidemensional array is collection of arrays
 */
	
	@Test(dataProvider="MyBooks")
	public void addBook(String isbn, String aisle) {
		
		URI.BookStoreURL();
		
	String response =	given().log().all().header("Content-Type","application/json")
		.body(PayLoad.addBook(isbn,aisle))
		.when().post("Library/Addbook.php").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
	    JsonPath js = new JsonPath(response);
	    String id = js.get("ID");
	    System.out.println("The ID is: "+id);
	//DELETE API
	
	}
	@DataProvider(name="MyBooks")
	public Object[][] getData() {
		
		return new Object[][] {{"nftyy","5587"},{"yutfb","3484"},{"polqj","9134"}};
	}
}
