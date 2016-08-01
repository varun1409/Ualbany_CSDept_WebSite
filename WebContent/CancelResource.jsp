<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.ResReserved" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/reserve.js"></script>
</head>
<body>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<div class="form">
<form action="ConfirmCancelResServlet" method="post" onsubmit="return myFunction2()">
<input type="hidden" id="resname" name="resname">
<input type="hidden" id="slot" name="slot">
<input type="hidden" id="date" name="date">
<h1>Cancel Reservation</h1>
<hr><br><br>

<%ArrayList<ResReserved> res=(ArrayList<ResReserved>)request.getAttribute("res"); 
if(res.size()>0)
{
	%>
<table border=1>
<tr>
<th>ReservationID</th>
<th>Resource</th>
<th>Date</th>
<th>Time</th>
<th> </th>
</tr>
	<%
	for(int i=0;i<res.size();i++)
	{
%>
<tr>
<td><%=res.get(i).getId() %></td>
<td><%=res.get(i).getResName() %></td>
<td><%=res.get(i).getDate() %></td>
<td><%=res.get(i).getTime() %></td>
<td><input type="submit" class="button" id=<%=res.get(i).getSlot()+res.get(i).getDate()+res.get(i).getResName()%> value="Cancel" onClick="cancelFunc(this.id)"/></td>
</tr>



<%}}
else{
%>
<h3>No reservations made.</h3>
<%} %>
</table>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>