package jdbc_tutorial;

import java.sql.*;

public class SelectExample {
	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";
	static final String QUERY = "SELECT * from Employees";
	
	public static void main(String[] args) {
		// Open a Connection 
		// try with resources block
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(QUERY);){
			
			while(rs.next()) {
				System.out.print("ID: "+rs.getInt("id"));
				System.out.print(", Age: "+rs.getInt("age"));
				System.out.print(", Name: "+rs.getString("first"));
				System.out.println(", Surname: "+rs.getString("last"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
				
		
	}

}
