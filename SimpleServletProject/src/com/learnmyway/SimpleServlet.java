package com.learnmyway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
/*@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletURL" },
initParams={@WebInitParam(name="defaultUser", value="John Doe")})*/
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello from GET method.");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if(name != null && name != ""){
			session.setAttribute("username", name);
			context.setAttribute("username", name);
		}
		PrintWriter out = response.getWriter();
		out.println();
		out.println("Request: "+name);
		out.println("Session: "+session.getAttribute("username"));
		out.println("Context: "+context.getAttribute("username"));
		
		String initParameter = this.getServletConfig().getInitParameter("defaultUser");
		out.println("Init parameter has default username from web.xml as "+initParameter);
	}

}
