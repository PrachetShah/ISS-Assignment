package loginPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	static final String DB_URL = "jdbc:mysql://localhost:3306/ASSIGNMENT";
	static final String USER = "prachet";
	static final String PASS = "root";
	static String QUERY = "SELECT * from Users WHERE email='?'";

	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)){

			// get user and pass from req
			String email = req.getParameter("email");
			String pass = req.getParameter("pass");
			//			System.out.println(email +" " + pass);

			// create prep statement to search from DB
			PreparedStatement stmt = conn.prepareStatement("select * from users where email=? and password=?");
			stmt.setString(1, email);
			stmt.setString(2, pass);

			ResultSet rs = stmt.executeQuery();

			PrintWriter out = res.getWriter();

			// see if user credentials are correct based on result
			if(rs.isBeforeFirst()) {
				out.write("User Exists and Valid");
				res.sendRedirect("home.html");
			}else {
				// if wrong credentials or user does not exist, then show alert
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect');");
				out.println("location='login.html';");
				out.println("</script>");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
