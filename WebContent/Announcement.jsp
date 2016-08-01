<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Announcement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Announcement</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/course.js"></script>
<script>
$(document).ready(function(){
	
	
	$("#form3").hide();
	$("#save").hide();
    $("#add").click(function(){
        $("#form3").toggle();
        
    });
    
 
});


</script>
</head>
<body>
<%
HttpSession annvhomesession	= request.getSession();	
String type=(String)annvhomesession.getAttribute("type");

boolean isStudent=false;

if(type.equals("student"))
	isStudent=true;
%>

<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>


<div class="form">
<h1>Announcements</h1>
<hr>
<%if(!isStudent){ %>
<input type="button" class="button" value="+ Add" id="add" name="add">
<%} %>
</div>
<div class="form3" id="form3">
<form action="AddAnncServlet" method="post" onSubmit="return checkAnnc()">
<div class="tableform">
<table>
<tr><td><label for="atype">Announcement Type*</label>
<select name="atype" id="atype" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="JOB">JOB</option>
                <option value="NEWS">NEWS</option>
                <option value="EVENTS">EVENTS</option>
</select>
</td><td><div id ="atypeerror"></div></td></tr>
<tr><td><label for="atitle">Title:*</label><input type="text" name="atitle" id="atitle"></td><td><div id ="atitleerror"></div></td></tr>
<tr><td><label for="adetails">Details:*</label><textarea name="adetails" id="adetails"></textarea></td><td><div id ="adetailserror"></div></td></tr>
<tr><td><label for="alinks">Related Links:</label><input type="text" name="alinks" id="alinks"></td><td><div id ="alinkserror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Add" ></td></tr><tr>
</table>
</div>
</form>
</div>



<%ArrayList<Announcement> c=(ArrayList<Announcement>)request.getAttribute("annc"); 
if(c.size()>0)
{
	%>
<div class="form2">
<form action="UpdateAppServlet" method="post">	

<table border=1>
<tr>
<th>ID</th>
<th>Type</th>
<th>Title</th>
<th>Email</th>

<th> </th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><%=c.get(i).getId() %></td>
<td><%=c.get(i).getType() %></td>
<td><%=c.get(i).getTitle() %></td>
<td><%=c.get(i).getEmail() %></td>



<td><input type="submit" class="button" id=<%=c.get(i).getId() %> value="View" onClick="clickFunction(this.id)"/></td>
</tr>

<%}} %>

</table>
<input type="hidden" id="cid2" name="cid2">
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>