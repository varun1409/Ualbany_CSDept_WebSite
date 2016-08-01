<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/register.css" rel="stylesheet">
 
<script type="text/javascript" src="js/register2.js">

</script>

<title>Register</title>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script>
$(document).ready(function(){
	
	
	$("#major").hide();
	$("#yoj").hide();
	$("#program").hide();
	$("#progLab").hide();
	$("#majLab").hide();
	$("#yojLab").hide();
	$('#user_type').on('change',function(){
	     var selection = $(this).val();
	    switch(selection){
	    case "student":
	    	$("#major").show();
	    	$("#yoj").show();
	    	$("#program").show();
	    	$("#progLab").show();
	    	$("#majLab").show();
	    	$("#yojLab").show();
	   break;
	    default:
	    	$("#major").hide();
			$("#yoj").hide();
			$("#program").hide();
			$("#progLab").hide();
			$("#majLab").hide();
			$("#yojLab").hide();
	    }
	});
  // });
    
 
});


</script>
</head>
<body>
<div class="header">
<%@ include file="headerno.jsp" %>
</div>

<div class="nav">
<%@ include file="insert.html" %>
</div>

<div class="form">
<form action="RegisterServlet" method="post" onsubmit="return myFunction()">
<h1>Register</h1>
<h5>*Please enter all mandatory fields</h5>
<hr>
<%String msg=(String)request.getAttribute("msg"); %>
<%if(msg!=null){ %>
<h3><%=msg %></h3>
<%} %>
<div class="tableform">
<table>
<tr>
<td><label for="d_specialization">Select:*</label>

<select name="user_type" id="user_type" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="student">STUDENT</option>
                <option value=staff>STAFF</option>
                <option value="faculty">FACULTY</option>
</select></td>
<td><div id ="user_typeerror"></div></td>

</tr>

<tr><td><label for="fname">First Name:*</label><input type="text" name="fname" id="fname"></td><td><div id ="fnameerror"></div></td></tr>
<tr><td><label for="lname">Last Name:*</label><input type="text" name="lname" id="lname"></td><td><div id ="lnameerror"></div></td></tr>
<tr><td><label for="address">Email:*</label><input type="text" name="address" id="address"></td><td><div id ="addresserror"></div></td></tr>
<tr><td><label for="email">Net Id:*</label><input type="text" name="email" id="email"></td><td><div id ="emailerror"></div></td></tr>
<tr><td><label for="password">Password:*</label><input type="password" name="password" id="password"></td><td><div id ="passworderror"></div></td></tr>
<tr><td><label for="confirmpassword">Confirm Password:*</label><input type="password" name="confirmPassword" id="confirmpassword"></td><td><div id ="confirmpassworderror"></div></td></tr>
<tr><td><label for="phone">Phone:*</label><input type="text" name="phone" id="phone"></td><td><div id ="phoneerror"></div></td></tr>
<tr><td><label id="progLab" for="program">Program:*</label>
<select name="program" id="program" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="BS">BS</option>
                <option value=BA>BA</option>
                <option value="MS">MS</option>
                <option value="PhD">PhD</option>
</select>
</td><td><div id ="programerror"></div></td></tr>
<tr><td><label id="majLab" for="major">Major:*</label><input type="text" name="major" id="major"></td><td><div id ="majorerror"></div></td></tr>
<tr><td><label id="yojLab" for="yoj">YOJ:*</label>
<select name="yoj" id="yoj" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="2016">2016</option>
				<option value="2015">2015</option>
				<option value="2014">2014</option>
				<option value="2013">2013</option>
                <option value="2012">2012</option>
				<option value="2011">2011</option>
				<option value="2010">2010</option>
				<option value="2009">2009</option>
				<option value="2008">2008</option>
                <option value="2007">2007</option>
				<option value="2006">2006</option>
				<option value="2005">2005</option>
				<option value="2004">2004</option>
				<option value="2003">2003</option>
				<option value="2002">2002</option>
				<option value="2001">2001</option>
				<option value="2000">2000</option>
</select>                
</td><td><div id ="joyerror"></div></td></tr>
<tr><td><input class="button" type="submit" value="Register" ></td></tr><tr>
</table>
</div>
</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>