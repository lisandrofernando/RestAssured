package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import files.URI;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {


	
	
	public io.restassured.specification.RequestSpecification RequestSpecification() throws FileNotFoundException {
	
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	io.restassured.specification.RequestSpecification req = new RequestSpecBuilder().setBaseUri(URI.uri()).addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
	
	return req;
	}
	
	public io.restassured.specification.ResponseSpecification ResponseSpecification() {
		
		io.restassured.specification.ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		return resspec;
	}
}
