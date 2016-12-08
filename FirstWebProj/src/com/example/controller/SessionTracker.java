package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewSessionInfo
 */
@WebServlet("/SessionTracker")
public class SessionTracker extends HttpServlet {

	private Integer visitCount; //a global counter to keep track of the total count
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession(true);
		
		visitCount = (Integer) session.getAttribute("visitCountK");
		String visitCountKey = new String("visitCountK");
		
		String userID = new String("ABCD");
		String userKey = new String("userId");
				
		if (visitCount == null)
		{
			visitCount = new Integer(0);
			session.setAttribute(userKey, userID);
			session.setAttribute(visitCountKey,visitCount);
			out.println("new session. visitCount="+visitCount);
		}
		else
		{
			visitCount = new Integer(visitCount.intValue() +1);
			session.setAttribute(visitCountKey, visitCount);
			out.println("old session. visitCount="+visitCount);
		}
		
		Date CreationTime = new Date(session.getCreationTime());
		Date LastAccessedTime = new Date (session.getLastAccessedTime());
		
		out.println("SessionID :"+session.getId());
		out.println("Create Time:" + CreationTime);
		out.println("Last Access Time:"+LastAccessedTime);
		out.println("User ID:"+session.getAttribute(userKey));
		out.println("Number of visits: "+ visitCount);
		
		//Format output in html table
		String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
		
	      out.println(docType +
	                "<html>\n" +
	                "<body bgcolor=\"#f0f0f0\">\n" +
	                "<h1 align=\"center\">Welcome back to website</h1>\n" +
	                 "<h2 align=\"center\">Session Infomation</h2>\n" +
	                "<table border=\"1\" align=\"center\">\n" +
	                "<tr bgcolor=\"#949494\">\n" +
	                "  <th>Session info</th><th>value</th></tr>\n" +
	                "<tr>\n" +
	                "  <td>JSessionID</td>\n" +
	                "  <td>" + session.getId() + "</td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Creation Time</td>\n" +
	                "  <td>" + CreationTime + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Time of Last Access</td>\n" +
	                "  <td>" + LastAccessedTime + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>User ID</td>\n" +
	                "  <td>" + session.getAttribute(userKey) + 
	                "  </td></tr>\n" +
	                "<tr>\n" +
	                "  <td>Number of visits</td>\n" +
	                "  <td>" + visitCount + "</td></tr>\n" +
	                "</table>\n" +
	                "</body></html>");
		
	}

}
