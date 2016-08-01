<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.Reservation" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserve Resource</title>
<script type="text/javascript" src="js/reserve.js"></script>
<link href="css/register.css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">

<script>
  $(function() {
    $( "#datepicker" ).datepicker({
        });
  });
 </script>
 <script>
$(document).ready(function(){
	
	
	$("#form4").hide();
	
    $("#add").click(function(){
        $("#form4").toggle();
        
    });
    
 
});


</script>
</head>
<body>
<%
HttpSession postsession	= request.getSession();	
String type=(String)postsession.getAttribute("type");
boolean isStaff=false;;
if(type.equals("staff"))
	isStaff=true;
%>
<div class="header">
<%@ include file="header.jsp" %>
</div>

<div class="nav">
<%@ include file="insertFaculty.jsp" %>
</div>


<div class="form">
<h1>Reservation</h1>
<hr>
<%if(isStaff){ %>
<input type="button" class="button" value="+ Add" id="add" name="add">
<%} %>
</div>


<div class="form4" id="form4">
<form action="AddResServlet" method="post" onsubmit="return addCheck()">

<div class="tableform">

<table>

<tr><td><label for="artype">Resource Type:*</label>
<select name="artype" id="artype" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="conferenceRoom">CONFERENCE ROOM</option>
                <option value="projector">PROJECTOR</option>
</select></td>
<td><div id ="artypeerror"></div></td></tr>
<tr><td><label for="arname">Resource Name:*</label><input type="text" name="arname" id="arname"></td><td><div id ="arnameerror"></div></td></tr>
<tr><td><label for="ardesc">Resource Desc:*</label><input type="text" name="ardesc" id="ardesc"></td><td><div id ="ardescerror"></div></td></tr>

<tr><td><input class="button" type="submit" value="Add" ></td></tr><tr>
</table>
</div>
</form>
</div>


<div class="form2">
<form action="ReserveCheckServlet" method="post" onsubmit="return myFunction()">
<%String msg=(String)request.getAttribute("msg");
if(msg!=null){%>
<h4><%=msg %></h4>
<%} %>
<select name="r_type" id="r_type" style="width: 174px;">
                <option value="dropdown">-------------SELECT-------------</option>
                <option value="conferenceRoom">CONFERENCE ROOM</option>
                <option value="projector">PROJECTOR</option>
</select><span id ="rselect_typeerror" style="text-align:center;color:red;width: 190px;"></span><br><br>
<input type="Text" id="datepicker" placeholder="Select date" style="text-align:center;width: 174px;background: transparent;" name="datepicker" class="searchBar" readonly="readonly" <%if(request.getAttribute("first")!=null) {%> value=<%=request.getAttribute("date") %><%} %>><span id ="dateerror" style="text-align:center;color:red;width: 190px;"></span><br><br>
<input class="button" type="submit" value="Check" >

</form>
</div>

<%if(request.getAttribute("first")!=null)
	{
	ArrayList<Reservation> res=(ArrayList<Reservation>)request.getAttribute("res");
	
%>
<div class="form3">
<form action="MakeReservationServlet" method="post" onsubmit="return myFunction2()">
<input type="hidden" id="resname" name="resname">
<input type="hidden" id="slot" name="slot">
<input type="hidden" id="date" name="date" value=<%=request.getAttribute("date") %>>
<%if(res.size()>0){for(int i=0;i<res.size();i++) {%>
<h3 style="font-weight:bold;"><%=res.get(i).getRname() %>-(<%=res.get(i).getRdesc() %>)</h3><br>
<table>
<tr>
<td><input id="slot1<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot1()){ %>class="buttongreen" value="08AM-09AM" type="submit"<%}else{ %>class="buttongray" value="08AM-09AM" type="button" <%} %>></td>
<td><input id="slot2<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot2()){ %>class="buttongreen" value="09AM-10AM" type="submit"<%}else{ %>class="buttongray" value="09AM-10AM" type="button" <%} %>></td>
<td><input id="slot3<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot3()){ %>class="buttongreen" value="10AM-11AM" type="submit"<%}else{ %>class="buttongray" value="10AM-11AM" type="button" <%} %>></td>
<td><input id="slot4<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot4()){ %>class="buttongreen" value="11AM-12PM" type="submit"<%}else{ %>class="buttongray" value="11AM-12PM" type="button" <%} %>></td>
<td><input id="slot5<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot5()){ %>class="buttongreen" value="12PM-01PM" type="submit"<%}else{ %>class="buttongray" value="12PM-01PM" type="button" <%} %>></td>
<td><input id="slot6<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot6()){ %>class="buttongreen" value="01PM-02PM" type="submit"<%}else{ %>class="buttongray" value="01PM-02PM" type="button"<%} %>></td>
<td><input id="slot7<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot7()){ %>class="buttongreen" value="02PM-03PM" type="submit"<%}else{ %>class="buttongray" value="02PM-03PM" type="button"<%} %>></td>
<td><input id="slot8<%=res.get(i).getRname()%>" onClick="clickFunction(this.id)" <%if(res.get(i).isSlot8()){ %>class="buttongreen" value="03PM-04PM" type="submit"<%}else{ %>class="buttongray" value="03PM-04PM" type="button"<%} %>></td>
</tr>
<tr>
<td><%=res.get(i).getSlot1Name() %></td>
<td><%=res.get(i).getSlot2Name() %></td>
<td><%=res.get(i).getSlot3Name() %></td>
<td><%=res.get(i).getSlot4Name() %></td>
<td><%=res.get(i).getSlot5Name() %></td>
<td><%=res.get(i).getSlot6Name() %></td>
<td><%=res.get(i).getSlot7Name() %></td>
<td><%=res.get(i).getSlot8Name() %></td>
</tr>
</table>
<%} }
else
{
	%>
<h3>No resource available on the selected date.</h3>
<%
}
}%>

</form>
</div>

<div class="footer">
<%@ include file="footer.jsp" %>
</div>

</body>
</html>