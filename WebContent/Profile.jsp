<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/register2.js">

</script>
</head>
<body>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>
<%HttpSession profsession	= request.getSession();	
String advisor=(String)profsession.getAttribute("advisor");
String netid=(String)profsession.getAttribute("email");
String phone=(String)profsession.getAttribute("phone");
String address=(String)profsession.getAttribute("address");
String type=(String)profsession.getAttribute("type");
boolean isStudent=false;;
if(type.equals("student"))
	 isStudent=true;
%>

<div class="form">
<form action="UpdateServlet" method="post" onsubmit="return myFunction()">
<h1>Update Profile</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<div class="tableform">
<table>
<tr><td><label for="netid">Net Id:*</label><input type="text" name="netid" id="netid" readonly="readonly" value=<%=netid %>></td><td><div id ="netiderror"></div></td></tr>
<tr><td><label for="phone">Phone:*</label><input type="text" name="phone" id="phone" value=<%=phone %>></td><td><div id ="phoneerror"></div></td></tr>
<tr><td><label for="email">Email:*</label><input type="text" name="email" id="email" value=<%=address %>></td><td><div id ="emailerror"></div></td></tr>
<%if(isStudent) {%>
<tr><td><label for="advisor">Advisor:*</label><input type="text" name="advisor" id="advisor" value=<%=advisor %>></td><td><div id ="advisorerror"></div></td></tr>
<%} %>
<tr><td><input class="button" type="submit" value="Update" ></td></tr><tr>
</table>
</div>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>