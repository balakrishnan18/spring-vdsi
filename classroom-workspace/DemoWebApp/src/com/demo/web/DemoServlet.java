package com.demo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String name=req.getParameter("name");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.write("<h1> Hi,"+name+" Welcome to Servlet</h1>");
	}
}
