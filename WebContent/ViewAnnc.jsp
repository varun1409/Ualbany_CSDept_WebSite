<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Announcement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/course.js"></script>
</head>
<body>
<%
HttpSession annvsession	= request.getSession();	
String email=(String)annvsession.getAttribute("email");

%>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<%Announcement c=(Announcement)request.getAttribute("a"); 

	%>


<div class="form" id="form">
<h1>View Announcement</h1>
<hr>
<form action="UpdateAServlet" method="post">
<div class="tableform">
<table>
<tr><td><label for="atype">Announcement Type*</label>
<input  name="atype" id="atype" readonly="readonly" value=<%=c.getType() %>>

</td><td><div id ="atypeerror"></div></td></tr>
<tr><td><label for="atitle">Title:*</label><textarea required cols="40" readonly="readonly" name="atitle" id="atitle"><%=c.getTitle() %></textarea></td><td><div id ="atitleerror"></div></td></tr>
<tr><td><label for="adetails">Details:*</label><textarea required cols="40" rows="20" readonly="readonly" name="adetails" id="adetails"><%=c.getDetails() %></textarea></td><td><div id ="adetailserror"></div></td></tr>
<tr><td><label for="alinks">Related Links:</label><textarea required cols="40" readonly="readonly" name="alinks" id="alinks"><%=c.getLinks() %></textarea></td><td><div id ="alinkserror"></div></td></tr>
<tr></tr>
<tr></tr>
<tr><td><input  class="button" type="button" value="Back" onclick="history.go(-1);"></td>
<td><input class="button" name="save" style="visibility:hidden;" id="save" type="submit" value="Save" ></td>
<%if(email.equals(c.getEmail())) {%>
<td><input class="button" name="update" id="update" type="button" value="Update" onClick="readFunc()"></td>
<td><input type="submit" formaction="DeleteAnncServlet?cid2=<%=c.getId() %>" name="delete" id="delete" class="button" value="Delete"></td></tr><tr>
<%} %>
</table>
<input type="hidden" id="id" name="id" value=<%=c.getId() %>>
</div>
</form> 
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>