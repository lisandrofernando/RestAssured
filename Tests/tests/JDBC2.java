package tests;
	
	
	import java.io.File;
import java.io.IOException;
import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
import java.util.ArrayList;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

	public class JDBC2 {

		String host ="localhost";
		String port ="3306";
		PojoJDBC db = null;
		ArrayList<PojoJDBC> list = new ArrayList<PojoJDBC>();
		
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
		  obj.writeValue(new  File("/Applications/RestAssured/companyInfo"+i+".json"), list.get(i) );
		  
		  con.close();
		}
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

