package servlets_jsp;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet{
	
	private String message;
	
	public void init() throws ServletException{
		// do required initialization
		message = "Hello World";
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// set content response type
		response.setContentType("text/html");
		
		// add actual logic here
		PrintWriter out = response.getWriter();
		out.println("<h1>"+message+"</h1>");
	}
	
	public void destroy() {
		// do nothing
	}
}
