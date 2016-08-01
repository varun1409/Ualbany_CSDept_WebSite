<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="css/register.css" rel="stylesheet">
</head>
<body>
<%
HttpSession postsession	= request.getSession();	
String name=(String)postsession.getAttribute("fname");

%>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>


<div class="form">
<h1>Welcome <%=name %></h1>
<h3>This is UAlbany computer science departments website.</h3>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>