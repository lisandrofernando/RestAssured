package tests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import files.URI;

public class TestSerialized {

	@Test
	public void serialized() {

		URI.uri();
		SerializationPojo pojo = new SerializationPojo();
		pojo.setAccuracy(50);
		pojo.setName("Frontline house");
		pojo.setPhone_number("(+91) 983 893 3937");
		pojo.setAddress("514-A Paseo Ecatepec");
		pojo.setWebsite("http://google.com");
		pojo.setLanguage("French-In");
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		pojo.setTypes(list);
		pojo.setLocation(l);

		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(pojo).when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).extract().response().asString();
		System.out.println(pojo);
	}
}
