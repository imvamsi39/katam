<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<style type="text/css">
body
{
background-color:pink;
text-align:center;
}
div
{
color:green;
}
h1
{
color:purple;
}
form
{
text-align:right;
}

</style>
</head>
<body>
<form>
<input type="submit" value="LOGOUT" formaction="Logout">
</form>
<div>You have Successfully logged IN</div>
<%
String user=String.valueOf(request.getSession().getAttribute("userSes"));
%>
<h1>
<%= "Welcome to "+user %>
</h1>

<%
  if(session.getAttribute("userSes")==null)
  {
	  response.sendRedirect("Login.html");
  }
  else
  {
	  out.println("Session Id:"+session.getId()+" is on\n"+session.getCreationTime());
	  out.println(session.getAttributeNames());
	  
	  response.setHeader("cache-control","no-cache,no-store,private,must-revalidate");
	  out.println("Contains Header: "+response.containsHeader("Cache-Control"));
	  
	  out.println("Header: "+response.getHeader("Cache-Control"));
  }
%>
<div>
<a href="videos.jsp">VIDEOS</a>
</div>
</body>
</html>