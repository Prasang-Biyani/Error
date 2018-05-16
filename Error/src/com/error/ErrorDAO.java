package com.error;
import java.sql.*;
import javax.sql.DataSource;
import javax.servlet.*;


import java.util.*;

//Interface Class Between Objects and Database
public class ErrorDAO {
	
	public static final ErrorDAO INSTANCE = new ErrorDAO();
	
	//error table Column Name
	public static String ERROR_SEARCH_EID = "eid";
	public static String ERROR_SEARCH_CATEGORY = "category";
	public static String ERROR_SEARCH_DESC = "descri";
	public static String ERROR_SEARCH_DATE = "Dte";
	public static String ERROR_SEARCH_TIME = "Tme";
	private Connection con;
	private ErrorDAO() {
		try {
		Class.forName("com.mysql.jdbc.Driver"); //Driver Registration for MYSQL
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Error?" + "user=prasang&password=prasang");	//Connecting to Database "Error"
		}
		catch(ClassNotFoundException ce) {	//Exception Maybe Thrown by Class.forName
			System.out.println(ce.getMessage());
		}
		catch(SQLException se) {	//SQLException Maybe Thrown by DriverManager
			System.out.println(se.getMessage());
		}
	}

	public List<Error> getErrorList(String query) throws SQLException{
		
		List<Error> errors = new ArrayList<Error>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query); //Query Execute
			
			//rs.beforeFirst();
			
			//Setting the Values of EID, CATEGORY, DESCRIPTION, DATE, TIME from the table error 
			while(rs.next()) {
				Error error = new Error();
				error.setEid(rs.getInt(ERROR_SEARCH_EID));
				error.setCategory(rs.getString(ERROR_SEARCH_CATEGORY));
				error.setDescription(rs.getString(ERROR_SEARCH_DESC));
				error.setDate(rs.getDate(ERROR_SEARCH_DATE));
				error.setTime(rs.getTime(ERROR_SEARCH_TIME));
					
				errors.add(error);
			}
		}
		catch(SQLException se) {
			System.out.println(se.getMessage());
		}
		
		return errors;
	}
}
