package files;

public class PayLoad {
	static String placeID;

	public static String AddPlace() {
		
		return "{\n"
				+ "  \"location\": {\n"
				+ "    \"lat\": -38.383494,\n"
				+ "    \"lng\": 33.427362\n"
				+ "  },\n"
				+ "  \"accuracy\": 50,\n"
				+ "  \"name\": \"Frontline house\",\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\n"
				+ "  \"types\": [\n"
				+ "    \"shoe park\",\n"
				+ "    \"shop\"\n"
				+ "  ],\n"
				+ "  \"website\": \"http://google.com\",\n"
				+ "  \"language\": \"French-IN\"\n"
				+ "}";
	}
	
	public static String UpadatePlace() {
		
		return "{\n"
				+ "\"place_id\":\""+placeID+"\",\n"
				+ "\"address\":\"70 Summer walk, USA\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}";
	}
	
	public static String addBook(String isbn, String aisle) {
		String payLoad = "{\n"
				+ "\n"
				+ "\"name\":\"Learn Appium Automation with Java\",\n"
				+ "\"isbn\":\""+isbn+"\",\n"
				+ "\"aisle\":\""+aisle+"\",\n"
				+ "\"author\":\"John foe\"\n"
				+ "}\n"
				+ "";
		return payLoad;
	}
	
	public static String jiraCookieAuth(String user, String pass) {
		
		return "{\"username\": \""+user+"\", \"password\": \""+pass+"\"}";
	}
	public static String createIssueJira(String summary, String description) {
		
		return "{\n"
				+ "    \"fields\": {\n"
				+ "        \"project\": {\n"
				+ "          \"key\": \"PRAC\"\n"
				+ "        },\n"
				+ "        \"summary\": \""+summary+"\",\n"
				+ "        \"description\":\""+description+"\",\n"
				+ "        \"issuetype\": {\n"
				+ "            \"name\": \"Bug\"\n"
				+ "        }\n"
				+ "    }\n"
				+ "}";
	}
	public static String addCommentJira(String comment) {
		
		return "{\n"
				+ "    \"body\": \""+comment+"\",\n"
				+ "    \"visibility\": {\n"
				+ "        \"type\": \"role\",\n"
				+ "        \"value\": \"Administrators\"\n"
				+ "    }\n"
				+ "}";
	}
}
