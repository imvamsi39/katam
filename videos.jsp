<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
WELCOME TO VIDEOS PAGE

<form>
<input type="submit" value="LOGOUT" formaction="Logout">
</form>
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
	  response.setHeader("cache-control","no-cache,no-store,must-revalidate");
  }
%>
</body>
</html>