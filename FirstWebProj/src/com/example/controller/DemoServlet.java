package com.example.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/DemoServlet")
//comment out @WebServlet("/DemoServlet") because it is already specified in web.xml. 
//Otherwise, the program can't run because of the conflict. 
public class DemoServlet extends HttpServlet {
	FileWriter fw;
	public void init(ServletConfig config)
	{
		
		String fileName=config.getInitParameter("fileName");
		try {
			fw=new FileWriter(fileName); //will create a new file as specified in web.xml
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("Servlet doGet() demo");
		out.close();
		
		fw.write("Happy coding " + new Date());
		fw.flush();
		System.out.println("written");
	}
	
	public void destroy(){
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
