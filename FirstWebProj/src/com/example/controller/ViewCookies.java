package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewCookies
 */
@WebServlet("/ViewCookies")
public class ViewCookies extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Cookie c[] = request.getCookies();
		PrintWriter out = response.getWriter();
		for (int i=0;i<c.length;i++)
		{
			out.println(c[i].getName()+" " +c[i].getValue());
		}
	}

}
