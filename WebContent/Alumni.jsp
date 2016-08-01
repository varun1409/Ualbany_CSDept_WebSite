<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Alumni" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alumni</title>
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
<script>
function alumniClick(id)
{

	var linkid="link".concat(id);
	var detailsid="details".concat(id);
	var nameid="name".concat(id);
	
  	//alert(selid);
  	var savid="save".concat(id);
  //	$().attr("disabled","disabled");
  	$("#"+linkid).prop("disabled", false); 
  	$("#"+detailsid).prop("disabled", false);
  	$("#"+nameid).prop("disabled", false);
  	
  	
  	document.getElementById(savid).style.visibility = "visible";

  	document.getElementById(id).style.visibility = "hidden";

	}
</script>
</head>
<body>
<%
HttpSession alumnihomesession	= request.getSession();	
String type=(String)alumnihomesession.getAttribute("type");

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
<h1>Alumni Information</h1>
<hr>
<%if(!isStudent){ %>
<input type="button" class="button" value="+ Add" id="add" name="add">
<%} %>
</div>

<div class="form3" id="form2">
<form action="AddAlumniServlet" onsubmit="return checkAlumni()" method="post">
<div class="tableform">
<table>
<tr><td><label for="alname">Alumni Group Name:*</label><input style="width:369px" type="text" name="alname" id="alname"></td><td><div id ="alnameerror"></div></td></tr>
<tr><td><label for="allink">Alumni Link:*</label><input style="width:369px" type="text" name="allink" id="allink"></td><td><div id ="allinkerror"></div></td></tr>
<tr><td><label for="aldetails">Alumni Details:*</label><textarea rows="7" cols="50" name="aldetails" id="aldetails"></textarea></td><td><div id ="aldetailserror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Add" ></td></tr><tr>
</table>
</div>
</form>
</div>



<%ArrayList<Alumni> c=(ArrayList<Alumni>)request.getAttribute("al"); 
if(c.size()>0)
{
	%>

<div class="form2">
<form action="ViewExamServlet" method="post">	

<table border=1>
<tr>
<th>Alumni Group Name</th>
<%if(!isStudent){ %>
<th>Alumni Link</th>
<%} %>
<th>Alumni Details</th>
</tr>
	<%
	for(int i=0;i<c.size();i++)
	{
%>
<tr>
<td><textarea required rows="15" disabled="disabled" name="name<%=i%>" id="name<%=i%>" ><%=c.get(i).getName() %></textarea></td>
<%if(!isStudent){ %>
<td><textarea required rows="15" disabled="disabled" name="link<%=i%>" id="link<%=i%>"><%=c.get(i).getLinks() %></textarea></td>
<%} %>
<td><textarea required cols="50" rows="15" disabled="disabled" name="details<%=i%>" id="details<%=i%>"><%=c.get(i).getDetails() %></textarea></td>
<td bgcolor="#000000"><a href=<%=c.get(i).getLinks() %> target="_blank">LINK</a></td>
<%if(!isStudent){ %>
<td><input type="button" id="<%=i %>"  class="button" value="Update" name="<%=i %>" onClick="alumniClick(<%=i%>)"/>
	<input type="submit" class="button" formaction="saveAlumniServlet?i=<%=i %>"  value="Save" style="visibility:hidden;float:right" id="save<%=i%>">
</td>
<%} %>

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