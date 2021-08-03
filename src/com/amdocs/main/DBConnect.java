package com.amdocs.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	
	Connection conn = null;

	public static Connection dbconn() {
		try {
			 Class.forName("oracle.jdbc.driver.OracleDriver");
	         Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","sys as sysdba","system");
	         
	         return conn;
	         
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
}