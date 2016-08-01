<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.DicsoInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/course.js"></script>


<script>
$(document).ready(function(){
	
	
	$("#form2").hide();
	$("#save").hide();
    $("#add").click(function(){
        $("#form2").toggle();
        
    });
    
 
});


</script>
</head>
<body>
<%
HttpSession discosession	= request.getSession();	
String type=(String)discosession.getAttribute("type");

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
<h1>Discussion Board</h1>
<hr>
<%if(!isStudent){ %>
<input type="button" class="button" value="+ Post" id="add" name="add">
<%} %>
</div>

<div class="form3" id="form2">
<form action="AddQuestionServlet" method="post" onSubmit="return checkDisco()">
<div class="tableform">
<table>
<tr><td><label for="qtitle">Title:*</label><input style="width:369px" type="text" name="qtitle" id="qtitle"></td><td><div id ="qtitleerror"></div></td></tr>
<tr><td><label for="qcontent">Question:*</label><textarea rows="7" cols="50" name="qcontent" id="qcontent"></textarea></td><td><div id ="qcontenterror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Post" ></td></tr><tr>
</table>
</div>
</form>
</div>

<%ArrayList<DicsoInfo> c=(ArrayList<DicsoInfo>)request.getAttribute("disco"); 
if(c.size()>0)
{
	%>

<div class="form2">
<form action="ViewPostServlet" method="post">	

<table border=1>
<tr>
<th>Post ID</th>
<th>Post Title</th>
<th>Created By</th>
<th>Time</th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><%=c.get(i).getPostid() %></td>
<td bgcolor="#000000"><a href="DisplayQuestionServlet?postid=<%=c.get(i).getPostid()%>"><%=c.get(i).getPtitle() %></a></td>
<td><%=c.get(i).getUsermail() %></td>
<td><%=c.get(i).getTime() %></td>

</tr>

<%}} %>

</table>

</form>
</div>
<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>