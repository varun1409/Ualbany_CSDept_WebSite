<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Course" %>
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



<div class="form">
<h1>Course Information</h1>
<hr>
<%if(!isStudent) {%>
<input type="button" class="button" value="+ Course" id="add" name="add">
<%} %>
</div>
<div class="form3" id="form3">
<form action="AddCourseInfoServlet" method="post" onsubmit="return checkCourse()" enctype="multipart/form-data">
<div class="tableform">
<table>
<tr><td><label for="cid">Course No.:*</label><input type="text" name="cid" id="cid"></td><td><div id ="ciderror"></div></td></tr>
<tr><td><label for="cname">Course Name:*</label><input type="text" name="cname" id="cname"></td><td><div id ="cnameerror"></div></td></tr>
<tr><td><label for="sem">Semester:*</label><input type="text" name="sem" id="sem"></td><td><div id ="semerror"></div></td></tr>
<tr><td><label for="OffLoc">Office Location:*</label><input type="text" name="OffLoc" id="OffLoc"></td><td><div id ="OffLocerror"></div></td></tr>
<tr><td><label for="offHours">Office Hours:*</label><textarea name="offHours" id="offHours" style="width:166px;height:45px;"></textarea></td><td><div id ="offHourserror"></div></td></tr>
<tr><td><label for="taemail">TA Email:*</label><input type="text" name="taemail" id="taemail"></td><td><div id ="taemailerror"></div></td></tr>
<tr><td><label for="ta">TA Details:*</label><textarea name="ta" id="ta" style="width:166px;height:80px;"></textarea></td><td><div id ="taerror"></div></td></tr>
<tr><td><label for="syllabus">Syllabus (only Pdf):</label><input type="file" name="syllabus" id="syllabus"></td><td><div id ="syllabuserror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Add" ></td></tr><tr>
</table>
</div>
</form>
</div>
<%if(!isStudent) {%>

<%ArrayList<Course> c=(ArrayList<Course>)request.getAttribute("course"); 
if(c.size()>0)
{
	%>
<div class="form2">
<h3>My Course</h3>
<form action="DeleteCourseInfoServlet" method="post" onsubmit="return myFunction3()">	

<table border=1>
<tr>
<th>Course ID</th>
<th>Course name</th>
<th>Office Hours</th>
<th>Office Location</th>
<th>Email</th>
<th>Semester</th>
<th>TA</th>
<th>Syllabus</th>
<th> </th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><%=c.get(i).getCid() %></td>
<td><%=c.get(i).getCname() %></td>
<td><%=c.get(i).getOfficeHours() %></td>
<td><%=c.get(i).getOfficeLoc() %></td>
<td><%=c.get(i).getProfEmail() %></td>
<td><%=c.get(i).getSemester() %></td>
<td><%=c.get(i).getTa() %></td>

<td><a style="color:blue;text-decoration: none;" href="DownloadServlet?cid=<%=c.get(i).getCid()%>">View</a></td>

<td><button disabled="disabled" class="button"><a style="color:white;text-decoration: none;" href="UpdateCourseServlet?cid=<%=c.get(i).getCid()%>">Update</a></button>
<input type="submit" class="button" id=<%=c.get(i).getCid() %> value="Delete" onClick="clickFunction(this.id)"/></th>

</tr>

<%}} %>

</table>
<input type="hidden" id="cid2" name="cid2">
</form>
</div>
<%} %>



<%ArrayList<Course> all=(ArrayList<Course>)request.getAttribute("allcourse"); 
if(all.size()>0)
{
	%>
<div class="form2">
<h3>All Courses</h1>
<form action="DeleteCourseInfoServlet" method="post" onsubmit="return myFunction3()">	

<table border=1>
<tr>
<th>Course ID</th>
<th>Course name</th>
<th>Office Hours</th>
<th>Office Location</th>
<th>Email</th>
<th>Semester</th>
<th>TA</th>
<th>Syllabus</th>
<th> </th>
</tr>
	<%
	for(int i=0;i<all.size();i++)
	{
%>
<tr>
<td><%=all.get(i).getCid() %></td>
<td><%=all.get(i).getCname() %></td>
<td><%=all.get(i).getOfficeHours() %></td>
<td><%=all.get(i).getOfficeLoc() %></td>
<td><%=all.get(i).getProfEmail() %></td>
<td><%=all.get(i).getSemester() %></td>
<td><%=all.get(i).getTa() %></td>

<td><a style="color:blue;text-decoration: none;" href="DownloadServlet?cid=<%=all.get(i).getCid()%>">View</a></td>
<%if(!isStudent) {%>
<td><button disabled="disabled" class="button"><a style="color:white;text-decoration: none;" href="UpdateCourseServlet?cid=<%=all.get(i).getCid()%>">Update</a></button>
<input type="submit" class="button" id=<%=all.get(i).getCid() %> value="Delete" onClick="clickFunction22(this.id)"/></th>
<%} %>
</tr>

<%}} %>

</table>
<input type="hidden" id="cid3" name="cid3">
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>