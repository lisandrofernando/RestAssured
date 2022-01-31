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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
 * The if check is to create only one instance of Request specification Method in case of running multiple tests so the logs will not
 * override the existing logs.
 */

public class Utils {


	public static RequestSpecification req;
	
	public io.restassured.specification.RequestSpecification RequestSpecification() throws FileNotFoundException {
	
	if(req==null) {	
	PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	io.restassured.specification.RequestSpecification req = new RequestSpecBuilder().setBaseUri(URI.uri()).addQueryParam("key", "qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
	return req;
	}else
	return req;
	}
	
	public io.restassured.specification.ResponseSpecification ResponseSpecification() {
		
		io.restassured.specification.ResponseSpecification resspec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		return resspec;
	}
	
	public String getJsonPath(Response response, String key) {
		
		String responseString = response.asString();
		JsonPath js = new JsonPath(responseString);
		 return  js.get(key).toString();
	}
}
