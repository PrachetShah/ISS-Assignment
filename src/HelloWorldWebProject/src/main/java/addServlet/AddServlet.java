package addServlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	String result;
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try {
			int num1 = Integer.parseInt(req.getParameter("num1"));
			int num2 = Integer.parseInt(req.getParameter("num2"));

			int result = num1+num2;
			System.out.println("Result is: "+result);
			PrintWriter out = res.getWriter();
			out.println("<h1>Result is: "+result+"</h1>");
		}catch(IOException i) {
			i.printStackTrace();
		}catch(Exception e) {
			System.out.println(e);
			PrintWriter out = res.getWriter();
			out.println("<h1>Access Denied</h1>");
		}



	}

}
