<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="css/register.css" rel="stylesheet">
<title>Login</title>
</head>
<div class="header">
<%@ include file="headerno.jsp" %>
</div>

<div class="nav">
<%@ include file="insert.html" %>
</div>
<body>


<div class="form">
<form action="LoginServlet" method="post" onsubmit="return myFunction()">

<h1>Login</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>

<div class="tableform">

<%String msg=(String)request.getAttribute("msg");
if(msg!=null){%>
<h4><%=msg %></h4>
<%} %>
<table>
<tr><td><label for="email">Email Id:*</label><input type="text" name="email" id="email"></td><td><div id ="emailerror"></div></td></tr>
<tr><td><label for="password">Password:*</label><input type="password" name="password" id="password"></td><td><div id ="passerror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Login" ></td></tr><tr>

</table>
</div>
</form>
</div>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>