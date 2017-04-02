package com.learnmyway;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		out.println("Hello from GET "+username);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("userName");
		String profession = request.getParameter("prof");
		String[] location = request.getParameterValues("location");
		out.println("Hello from POST "+username);
		out.println("You are "+profession);
		if(location != null){
			out.println("You are at "+location.length+" places");
			for(String loc : location){
				out.print(loc+" ");
			}
		}
	}
}