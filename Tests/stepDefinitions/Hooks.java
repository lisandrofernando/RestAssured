package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	/*
	 * Add some smart way to execute the code when delete call is running without depending on a strait run from previous code.
	 */
	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		
		AddStepDefinion step = new AddStepDefinion();
		
		if(AddStepDefinion.placeID ==null) {
		
		step.add_place_payload_with_something_something_something("Lisandro", "Portuguese", "Mexico");
		step.user_calls_something_with_something_http_request("AddPlaceAPI","POST");
		step.verify_placeid_created_maps_to_something_using_something("Lisandro", "getPlaceAPI");
	   }
	}
}
