package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.PayLoad;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	JsonPath js = new JsonPath(PayLoad.CoursePrice());
	int count;
	String courseTitles;
	int price;
	int copies;
	int sum = 0;
	@Test
	public void ParseComplexJson() {
		
	
	   count =  js.getInt("courses.size()");
		System.out.println(count);
		 int totalAmount = js.getInt("dashboard.purchaseAmount");
		 System.out.println(totalAmount);
		 String firstTitle = js.get("courses[0].title");
		 System.out.println(firstTitle);
		 String thirdTitle = js.get("courses[2].title");
		 System.out.println(thirdTitle);
		 
		 for(int i=0; i<count; i++) {
			 
		String courseTitles =js.get("courses["+i+"].title");
		String coursePrices =js.get("courses["+i+"].price").toString();
		System.out.println(courseTitles);
		System.out.println(coursePrices);
			 
		 }
		
	}
	@Test
	public void parseCopies() {
		for (int i=0; i<count; i++) {
	     courseTitles =js.get("courses["+i+"].title");
	     if(courseTitles.equalsIgnoreCase("Cypress")) {
	    	 
	    	 copies = js.get("courses["+i+"].copies");
	    	 System.out.println("The number of copies are :"+copies);
	    	 break;
	     }
			
	  }
		
		
  }
	@Test
	public void sumValidation() {
		count = js.getInt("courses.size()");
		for(int i=0; i<count; i++) {
			
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println("The amount is :"+amount);
			 sum = sum + amount;
		}
		System.out.println("The sum is :"+sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(purchaseAmount, sum);
	}
	
}
