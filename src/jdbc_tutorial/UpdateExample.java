package jdbc_tutorial;

import java.sql.*;

public class UpdateExample {
	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";
	static final String QUERY_SELECT = "SELECT * from Employees";
	static final String QUERY_UPDATE = "UPDATE Employees SET AGE=21 where ID=100";
	
	public static void main(String[] args) {
		// Open a Connection 
		// try with resources block
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement();
			){
			// executing update statement using executeUpdate()
			stmt.executeUpdate(QUERY_UPDATE);
			
			// executing query statement which returns a ResultSet
			ResultSet rs = stmt.executeQuery(QUERY_SELECT);
			
			// extract data from result
			while(rs.next()) {
				System.out.print("ID: "+rs.getInt("id"));
				System.out.print(", Age: "+rs.getInt("age"));
				System.out.print(", Name: "+rs.getString("first"));
				System.out.println(", Last: "+rs.getString("last"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
