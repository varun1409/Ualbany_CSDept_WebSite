<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Phd" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(document).ready(function(){
	

	$("input").click(function() {
		
	    var id=(this.id).substring(6); 
	  	var selid="select".concat(id);
	  	//alert(selid);
	  	var savid="save".concat(id);
	  //	$().attr("disabled","disabled");
	  	$("#"+selid).prop("disabled", false); 
	  	document.getElementById(savid).style.visibility = "visible";
	  	document.getElementById(this.id).style.visibility = "hidden";
	   // or alert($(this).attr('id'));
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


<%ArrayList<Phd> c=(ArrayList<Phd>)request.getAttribute("phd"); 
if(c.size()>0)
{
	%>
	

<div class="form">
<h1>PhD Students</h1>
<hr>
<form action="" method="post">	

<table border=1>
<tr>
<th>Student Name</th>
<th>Program</th>
<th>Major</th>
<th>YOJ</th>
<th>Email</th>
<th>Is Candidate</th>
<th> </th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><%=c.get(i).getName() %></td>
<td><%=c.get(i).getProgram() %></td>
<td><%=c.get(i).getMajor() %></td>
<td><%=c.get(i).getYoj() %></td>
<td><%=c.get(i).getEmail() %></td>
<% 
String val;
if(c.get(i).getIsCandidate().equals("No"))
val="Yes";	
else
val="No";
	
	%>
<td><select name="select<%=i%>" disabled="disabled" id="select<%=i%>" style="width: 174px;">
                <option value=<%=c.get(i).getIsCandidate()%>><%=c.get(i).getIsCandidate() %></option>
                <option value=<%=val %>><%=val %></option>
</select></td>
<td><input type="button" class="button" value="Update" style="float:right" id="update<%=i%>">
	<input type="submit" class="button" formaction="savePhdStatusServlet?i=<%=i %>"  value="Save" style="visibility:hidden;float:right" id="save<%=i%>"></td>

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