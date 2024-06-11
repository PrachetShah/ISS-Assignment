package jdbc_tutorial;

import java.sql.*;

/*
 * If your JDBC Connection is in auto-commit mode, which it is by default, then every 
 * SQL statement is committed to the database upon its completion.
 * That may be fine for simple applications, but there are three reasons why you may 
 * want to turn off the auto-commit and manage your own transactions − 
 * 1.To increase performance.
 * 2.To maintain the integrity of business processes.
 * 3.To use distributed transactions.
 * 
 * Transactions enable you to control if, and when, changes are applied to the database. 
 * It treats a single SQL statement or a group of SQL statements as one logical unit, 
 * and if any statement fails, the whole transaction fails.
 * 
 * We can also rollback to specified **SAVEPOINT** if given in rollback(savepoint)
 * --set a Savepoint 
 * Savepoint savepoint1 = conn.setSavepoint("Savepoint1");
 * 
 * -- delete savepoint
 * releaseSavepoint(String name);
 */

public class Transactions {

	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";


	public static void main(String[] args) throws Exception {

		// create a connection
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		try{
			
			// setting auto commit as false to rollback if error arises
			conn.setAutoCommit(false);
			Statement stmt = conn.createStatement();

			String SQL = "INSERT INTO Employees  " +
					"VALUES (106, 20, 'Rita', 'Tez')";
			stmt.executeUpdate(SQL);  

			//Submit a malformed SQL statement that breaks
			String SQL2 = "INSERTED IN Employees  " +
					"VALUES (107, 22, 'Sita', 'Singh')";
			stmt.executeUpdate(SQL2);

			// If there is no error.
			conn.commit();
		}catch(SQLException se){
			// If there is any error.
			conn.rollback();
		}
	}

}
