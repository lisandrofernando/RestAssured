package tests;
	
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;

	import org.testng.annotations.Test;

	public class JDBC {

		String host ="localhost";
		String port ="3306";
		
		@Test
		public void dataBaseTest() throws SQLException {
			
		  Connection con = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/DemoQA","root","Lisandro100@");
		  Statement s =      con.createStatement();
		  ResultSet result =   s.executeQuery("select * from EmployeeInfo");
		  while(result.next()) {
		  System.out.println(result.getString("name"));
		  System.out.println(result.getString("id"));
		  }
		  
		}
	}

