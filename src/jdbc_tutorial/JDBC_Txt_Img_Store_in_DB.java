package jdbc_tutorial;

import java.sql.*;
import java.io.*;

public class JDBC_Txt_Img_Store_in_DB {
	
	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";

	public static void main(String args[]) throws Exception {

		//Getting the connection
		Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
		System.out.println("Connection established......");
		
		// create a table for storing images as blobs and text as clobs
		Statement stmt = con.createStatement();
		// not needed once table is created
//		stmt.execute("CREATE TABLE JDBC_BLOB_CLOB (plain_text longtext, name varchar (255), image longblob)");
		
		//Inserting values using a prepared statement
		String query = "INSERT INTO JDBC_BLOB_CLOB(Name, PLAIN_TEXT, IMAGE) VALUES (?, ?, ?)";
		PreparedStatement pstmt = con.prepareStatement(query);
		
		// adding name for row
		pstmt.setString(1, "ClOB_BLOB Example");
		// adding file as clob in db
		FileReader fileReader = new FileReader("C:\\Users\\prach\\Desktop\\db creds.txt");
		pstmt.setClob(2, fileReader);
		// adding img as inputStream as blob in db
		InputStream inputStream = new FileInputStream("C:\\Users\\prach\\Desktop\\Haikyu\\hinata.jpg");
		pstmt.setBlob(3, inputStream);
		
		// executing prepared statement
		pstmt.execute();
		System.out.println("Record inserted......");

		//Retrieving the results
		ResultSet rs = stmt.executeQuery("SELECT * from jdbc_blob_clob");
		// looping each row in table with cursor
		while(rs.next()) {
			String name = rs.getString("Name");
			Clob clob = rs.getClob("plain_text");
			Blob blob = rs.getBlob("image");
			System.out.println("Name: "+name);
			System.out.println("Clob value: "+clob);
			System.out.println("Blob value: "+blob);
			System.out.println("");
			
			System.out.print("Clob data is stored at: ");
			//Storing clob to a file
			int i = 0; 
			Reader r = clob.getCharacterStream(); // get char stream from clob
			String filePath = "C:\\Users\\prach\\Desktop\\clob_output_mysql_create_table.txt"; // define output path
			FileWriter writer = new FileWriter(filePath); // create a new filewriter instance
			while ((i=r.read())!=-1) {
				writer.write(i);
			}
			writer.close();
			System.out.println(filePath);

			System.out.print("Blob data is stored at: ");
			InputStream is = blob.getBinaryStream(); // get binary stream from blob
			/*
			 * --------------IMP---------------
			 * read() calls are said to be 'blocking' method calls, ie if no data is available it will wait for data
			 * hence, available() method tells you how many bytes can be read until the read() call will block 
			 * the execution flow of your program. On most of the input streams, all call to read() are blocking, 
			 * that's why available returns 0 by default.
			 */
			byte byteArray[] = new byte[is.available()];
			is.read(byteArray);
			filePath = "C:\\Users\\prach\\Desktop\\output_hinata_blob_java.jpg";
			FileOutputStream outPutStream = new FileOutputStream(filePath);
			outPutStream.write(byteArray);
			System.out.println(filePath);
			outPutStream.close();
		}
	}
}
