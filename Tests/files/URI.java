package files;

import io.restassured.RestAssured;

public class URI {
	
	public static String uri() {
		
		String url = RestAssured.baseURI= "https://rahulshettyacademy.com";
		return url;
	}
	
	public static String jiraURI() {
		
		String url = RestAssured.baseURI= "http://localhost:8080";
		return url;
	}

}
