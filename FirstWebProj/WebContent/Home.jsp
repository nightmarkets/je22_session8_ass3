<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Hi, 
<%
	String userName1 = (String) session.getAttribute("userName2"); //session is created in LoginServlet
	out.println(userName1);
	out.println("SessionID :"+session.getId());
%>
<br>
<a href="Logout">logout</a>
<br>

<a href="ViewCookies"> View this site cookies</a>
<br>

<a href="SessionTracker"> View this session info</a>

</body>
</html>