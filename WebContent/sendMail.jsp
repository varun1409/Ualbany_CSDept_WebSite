<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Course" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
</head>
<body>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<%ArrayList<Course> st=(ArrayList<Course>)request.getAttribute("st"); %>
<div class="form">
<h1>Send Email</h1>
<hr>
<% 
if(st.size()>0)
{
	%>

<table border=1>
<tr>
<th>Course Id</th>
<th>Course Name</th>
<th>Prof. Email</th>
<th>Ta Email</th>
</tr>
<%for(int i=0;i<st.size();i++) 
{%>

<tr>
<td><%=st.get(i).getCid() %></td>
<td><%=st.get(i).getCname() %></td>
<td><a href="mailto:<%=st.get(i).getProfEmail() %>">Send email</a></td>
<td><a href="mailto:<%=st.get(i).getTa() %>">Send email</a></td>
<%} %>

	<% 
}
else
{
%>
<h3>No course available</h3>
<%} %>
</table>
</div>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>