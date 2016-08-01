<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.SimpleDateFormat,csdept.DicsoInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/register.css" rel="stylesheet">
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

<%ArrayList<DicsoInfo> rep=(ArrayList<DicsoInfo>)request.getAttribute("rep");
DicsoInfo post=(DicsoInfo)request.getAttribute("ques");%>
<div class="form">
<form action="ReplyServlet" method="post">

<h1><%=post.getPtitle() %>
<%if(!isStudent){ %>
<a href="DeletePostServlet?id=<%=post.getPostid() %>">
<img border="0" alt="Delete" src="img/close2.png" width="15" height="15">
</a>
<%} %>
</h1>
<h5><span style="float:left"><%=post.getUsermail() %></span><span style="float:right"><%=post.getTime() %></span></h5><br><br>
<h3 style="border=1"><%=post.getPcontent() %></h3>




<%for(int i=0;i<rep.size();i++){ %>
<ul  style="list-style-type: none";>
<li style="color:red"><%=rep.get(i).getUsermail() %>
<%if(!isStudent){ %>
<a href="DeleteReplyServlet?id=<%=rep.get(i).getPostid()%>">
<img border="0" alt="delete" src="img/close2.png" width="10" height="10">
</a>
<%} %>
</li>
<li><%=rep.get(i).getPcontent()%></li>
</ul>

<%} %>
<textarea rows="7" required cols="100" id="reply" name="reply"></textarea><br><br>
<input class="button" value="Reply" type="submit">
<input type="hidden" id="postid" name="postid" value=<%=post.getPostid() %>>
</form>
</div>


<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>