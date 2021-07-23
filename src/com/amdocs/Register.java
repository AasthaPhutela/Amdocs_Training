package com.amdocs;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.amdocs.admin.Admin;
import com.amdocs.Employee;

public class Register {
	
	public static int registerUser(Employee employee) throws ClassNotFoundException{
		
		String INSERT_USERS_SQL ="INSERT INTO employee" +
	            "  (first_name, last_name, username, password, address, contact) VALUES " +
	            " (?, ?, ?, ?,?,?);";
		
		int result = 0;
		
		try (Connection con = DBConnect.dbconn();
		
		PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
          preparedStatement.setString(1,employee.getFirstName());
          preparedStatement.setString(2,employee.getLastName());
          preparedStatement.setString(3,employee.getUsername());
          preparedStatement.setString(4,employee.getContact());
          preparedStatement.setString(5,employee.getAddress());
          preparedStatement.setString(6,employee.getPassword());
          

          result = preparedStatement.executeUpdate();
          
		}catch (SQLException e) {
			
			printSQLException(e);
		}
		return result;
	}
	private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
	/*public static int registerAdmin(Admin admin) throws ClassNotFoundException{
			
			String INSERT_USERS_SQL = "INSERT INTO admin" +
		            "  (name,email,password) VALUES " +
		            " (?, ?, ?);";
			
			int result = 0;
			
			try (Connection con = DBConnect.dbconn();
			
			PreparedStatement preparedStatement = con.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setString(1, admin.getName());
	            preparedStatement.setString(2, admin.getEmail());
	            preparedStatement.setString(3, admin.getPassword());
	
	            result = preparedStatement.executeUpdate();
		}
			catch (SQLException e) {
	        printSQLException(e);
	    }
	    return result;
	}

  private static void printSQLException(SQLException ex) {
      for (Throwable e: ex) {
          if (e instanceof SQLException) {
              e.printStackTrace(System.err);
              System.err.println("SQLState: " + ((SQLException) e).getSQLState());
              System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
              System.err.println("Message: " + e.getMessage());
              Throwable t = ex.getCause();
              while (t != null) {
                  System.out.println("Cause: " + t);
                  t = t.getCause();
              }
          }
      }
  }*/
  

