package registerPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet{
	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";
	static String QUERY = "INSERT INTO Users VALUES(?, ?)";

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){

			PrintWriter out = res.getWriter();
			//			out.write("Register Page");

			String email = req.getParameter("email");
			String pass = req.getParameter("pass");

			PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
			stmt.setString(1, email);
			stmt.setString(2, pass);

			try{
				stmt.execute();
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User Registered, Redirecting to Login Page');");
				   out.println("location='login.html';");
				   out.println("</script>");
			}catch(Exception e) {
				out.println("<script type=\"text/javascript\">");
				   out.println("alert('User Already Exists, Login Now');");
				   out.println("location='login.html';");
				   out.println("</script>");
				out.write("User Already registered");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}

