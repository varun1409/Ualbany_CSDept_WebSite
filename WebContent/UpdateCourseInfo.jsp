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

<%Course c=(Course)request.getAttribute("c"); 

	%>

<div class="form" id="form">
<form action="AddCourseInfoServlet" method="post" enctype="multipart/form-data">
<div class="tableform">
<table>
<tr><td><label for="cid">Course No.:*</label><input required type="text" readonly="readonly" name="cid" id="cid" value=<%=c.getCid() %>></td><td><div id ="ciderror"></div></td></tr>
<tr><td><label for="cname">Course Name:*</label><input required type="text" name="cname" id="cname" value=<%=c.getCname() %>></td><td><div id ="cnameerror"></div></td></tr>
<tr><td><label for="sem">Semester:*</label><input required type="text" name="sem" id="sem" value=<%=c.getSemester() %>></td><td><div id ="semerror"></div></td></tr>
<tr><td><label for="OffLoc">Office Location:*</label><input required type="text" name="OffLoc" id="OffLoc" value=<%=c.getOfficeLoc() %>></td><td><div id ="OffLocerror"></div></td></tr>
<tr><td><label for="offHours">Office Hours:*</label><textarea required name="offHours" id="offHours" style="width:166px;height:45px;"><%=c.getOfficeHours() %></textarea></td><td><div id ="offHourserror"></div></td></tr>
<tr><td><label for="ta">TA Details:*</label><textarea required type="text" name="ta" id="ta"  style="width:166px;height:80px;"><%=c.getTa() %></textarea></td><td><div id ="taerror"></div></td></tr>
<tr><td><label for="syllabus">Syllabus(only Pdf):</label><input type="file" name="syllabus" id="syllabus"></td><td><div id ="syllabuserror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Save" ></td></tr><tr>
</table>
</div>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>