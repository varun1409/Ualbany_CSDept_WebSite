<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.ExamInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script type="text/javascript" src="js/course.js"></script>
<link href="css/register.css" rel="stylesheet">


<script>
  $(function() {
    $("#edate").datepicker({  minDate: 0
        });
  });
 </script>
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

<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>

<div class="form">
<h1>Department Exam Results</h1>
<hr>
<input type="button" class="button" value="+ Add" id="add" name="add">
</div>

<div class="form3" id="form2">
<form action="AddResultsServlet" method="post" onSubmit="return checkExam()">
<div class="tableform">
<table>
<tr><td><label for="etitle">Exam Name:*</label><input style="width:169px" type="text" name="etitle" id="etitle"></td><td><div id ="etitleerror"></div></td></tr>
<tr><td><label for="esemester">Semester:*</label><input style="width:169px" type="text" name="esemester" id="esemester"></td><td><div id ="esemestererror"></div></td></tr>
<tr><td><label for="edate">Date:*</label><input style="width:169px" type="text" name="edate" readonly="readonly" id="edate"></td><td><div id ="edateerror"></div></td></tr>


<tr><td><input class="button" type="submit" value="Post" ></td></tr><tr>
</table>
</div>
</form>
</div>


<%ArrayList<ExamInfo> c=(ArrayList<ExamInfo>)request.getAttribute("exam"); 
if(c.size()>0)
{
	%>

<div class="form2">
<form action="ViewExamServlet" method="post">	

<table border=1>
<tr>
<th>Exam Name</th>
<th>Exam Date</th>
<th>Semester</th>
<th>Created By</th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><%=c.get(i).getEname() %></td>
<td><%=c.get(i).getEdate() %></td>
<td><%=c.get(i).getEsemester() %></td>
<td><%=c.get(i).getEmail() %></td>
<td><input type="submit" id="<%=c.get(i).getEid() %>"  class="button" value="View" name="<%=c.get(i).getEid() %>" onClick="examClick(this.id)"/></td>

</tr>

<%}} %>

</table>
<input type="hidden" id="eid" name="eid">
</form>
</div>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>