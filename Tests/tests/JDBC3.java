package tests;
	
	
	import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

	public class JDBC3 {

		String host ="localhost";
		String port ="3306";
		PojoJDBC db = null;
		ArrayList<PojoJDBC> list = new ArrayList<PojoJDBC>();
		JSONArray js = new JSONArray();
		
		
		@Test
		public void dataBaseTest() throws SQLException, JsonGenerationException, JsonMappingException, IOException {
			
		
			
		  Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/DemoQA","root","Lisandro100@");
		  Statement s =      con.createStatement();
		  ResultSet result =   s.executeQuery("select Name, Branch, employees from company");
		  while(result.next()) {
				PojoJDBC db = new PojoJDBC();
		        db.setName(result.getString(1));
		        db.setBranch(result.getString(2));
		        db.setEmployees(result.getInt(3));
		        list.add(db);
		        
		        System.out.println(db.getName());
		        System.out.println(db.getBranch());
		        System.out.println(db.getEmployees());
		       
		  }
		  for(int i=0; i<list.size(); i++) {
		  ObjectMapper obj = new ObjectMapper();
		  obj.writeValue(new  File("/Applications/RestAssured/ExpectedInfo"+i+".json"), list.get(i) );
		  Gson g = new Gson();
		   String jsonString =    g.toJson(list.get(i));
		   js.add(jsonString);
		  
		}
		 
		  JSONObject json = new JSONObject();
		  json.put("data", js);
		  System.out.println(json.toJSONString());
		  String unescapedString = StringEscapeUtils.unescapeJava(json.toString());
		  System.out.println(unescapedString);
		  String first = unescapedString.replace("\"{", "{");
		  String otherStr = first.replace("}\"", "}");
		  System.out.println(otherStr);
		  
		  try 
	          ( FileWriter file = new FileWriter("/Applications/RestAssured/ExpectedInfoSec.json")) {
	            file.write(otherStr);
	        }
			  
		  
		  con.close();
//		
//		@Test
//		public void dataBaseTestOne() throws SQLException {
//			
//		  Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/word","root","Lisandro100@");
//		  Statement s =      con.createStatement();
//		  ResultSet result =   s.executeQuery("select * from CustomerInfo");
//		  while(result.next()) {
//		  System.out.println(result.getString("firstName"));
//		  System.out.println(result.getString("gender"));
//		  }
//		  con.close();
//		}
	}
	}

