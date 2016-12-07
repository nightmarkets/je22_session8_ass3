package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")

public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		String user = req.getParameter("userName");
		String pass = req.getParameter("passWord");
		/*
		PrintWriter out = res.getWriter();
		out.println("Welcome "+userName);
		out.close();
		*/
		
		if(user.equals("tom")&&pass.equals("tom123"))
		{
			
			HttpSession session = req.getSession(true);
			session.setAttribute("userName2", user);
			
			Cookie c1 = new Cookie("userNameC", user);
			c1.setMaxAge(60*60*24);
			c1.setHttpOnly(true);
			res.addCookie(c1);
			
			Cookie c2 = new Cookie("passWordC", pass);
			c2.setMaxAge(60*60*24);
			c2.setHttpOnly(true);
			res.addCookie(c2);
			
			res.sendRedirect("Home.jsp");
		}
		else
		{
		res.sendRedirect("index.jsp");
		}
		
	}

}
