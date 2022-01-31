package resources;

import java.util.ArrayList;
import java.util.List;

import tests.Location;
import tests.SerializationPojo;

public class TestData {

	public SerializationPojo addPlacePojo(String name, String language, String address) {
		
		SerializationPojo pojo = new SerializationPojo();
		pojo.setAccuracy(50);
		pojo.setName(name);
		pojo.setPhone_number("(+91) 983 893 3937");
		pojo.setAddress(address);
		pojo.setWebsite("http://google.com");
		pojo.setLanguage(language);
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		pojo.setTypes(list);
		pojo.setLocation(l);
		
		return pojo;
	}
	public String deletePlacePayload(String placeID) {
		return "{\n"
				+ "    \"place_id\":\""+placeID+"\"\n"
				+ "}";
	}
}
