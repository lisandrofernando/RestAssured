package files;

import io.restassured.RestAssured;

public class URI {
	
	private static String url = RestAssured.baseURI= "https://rahulshettyacademy.com";
	private static String jiraURL = "http://localhost:8080";
	private static String BookStoreURL ="http://216.10.245.166";
	
	public static String uri() {
	
		return url;
	}
	
	public static String jiraURI() {
		
		return jiraURL;
	
	}

	public static String BookStoreURL() {
		
		return BookStoreURL;
	
	}

}
