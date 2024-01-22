package resources;

/*
 * Enum is a special class in java which has a collections of methods or constants
 * The constructor will be called with value of resource which you pass
 * //tagName[@attributeName="attributeValue"]
 * //a[text()='value']
 */
public enum APIResources {

	AddPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	deletePlaceAPI("/maps/api/place/delete/json");
	private String resource;
	
	 APIResources(String resource) {
		
		 this.resource = resource;
	}
	 
	 public String getResource() {
		 
		 return resource;
	 }
}
