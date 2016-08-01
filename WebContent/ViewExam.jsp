<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.ExamInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
<script type="text/javascript" src="js/course.js"></script>
</head>
<body>
<%
HttpSession postsession	= request.getSession();	
String type=(String)postsession.getAttribute("type");
boolean isStudent=false;;
if(type.equals("student"))
	 isStudent=true;
%>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<%ExamInfo e=(ExamInfo)request.getAttribute("e"); 

	%>

<div class="form" id="form">
<h1>View Exam</h1>
<hr>
<form action="UpdateExamServlet" method="post">
<div class="tableform">
<table>
<tr><td><label for="etitle">Exam Name:*</label><input required style="width:369px" type="text" name="etitle" id="etitle" readonly="redonly" value=<%=e.getEname() %>></td><td><div id ="etitleerror"></div></td></tr>
<tr><td><label for="esemester">Semester:*</label><input required style="width:369px" type="text" name="esemester" id="esemester" readonly="redonly" value=<%=e.getEsemester() %>></td><td><div id ="esemestererror"></div></td></tr>
<tr><td><label for="edate">Date:*</label><input required style="width:369px" type="text" name="edate" readonly="readonly" id="edate" value=<%=e.getEdate() %>></td><td><div id ="edateerror" ></div></td></tr>
<tr><td><label for="econtent">Results:*</label><textarea required rows="7" cols="50" name="econtent" id="econtent" readonly="redonly"><%=e.getEcontent() %></textarea></td><td><div id ="econtenterror"></div></td></tr>

<tr></tr>
<tr></tr>
<tr><td><input  class="button" type="button" value="Back" onclick="history.go(-1);"></td>
<td><input class="button" name="save" style="visibility:hidden;" id="save" type="submit" value="Save" ></td>
<%if(!isStudent){ %>
<td><input class="button" name="update" id="update" type="button" value="Update" onClick="readExamFunc()"></td>
<td><input type="submit" formaction="DeleteExamServlet?eid=<%=e.getEid() %>" name="delete" id="delete" class="button" value="Delete"></td></tr><tr>
<%}else
	{
	boolean isR=(Boolean)request.getAttribute("isReg");
	System.out.println(isR);
	%>
<td><input formaction="RegisterExamServlet?eid=<%=e.getEid() %>" name="regexam" id="regexam" value="Register" <%if(isR){%>type="button" class="buttongray"  <%}else{%> type="submit" class="buttongreen" <%} %>></td></tr><tr>
<%} %>
</table>
<input type="hidden" id="id" name="id" value=<%=e.getEid() %>>
</div>
</form> 
</div>
<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>