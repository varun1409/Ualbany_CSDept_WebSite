<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Announcement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply jobs</title>
<link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<div class="form">
<h1>Job List</h1>
<hr>
<% ArrayList<Announcement> job=( ArrayList<Announcement>)request.getAttribute("jobs");
if(job.size()>0)
{
	%>

<table border=1>
<tr>
<th>Job Title</th>
<th>Job Details</th>
<th>Link</th>

</tr>	
	<%
	for(int i=0;i<job.size();i++)
{
%>
<tr>
<td><%=job.get(i).getTitle() %></td>
<td><%=job.get(i).getDetails() %></td>
<td><a href="<%=job.get(i).getLinks() %>">Apply</a></td>
</tr>

<%} %>
</table>
<%} %>

</div>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>