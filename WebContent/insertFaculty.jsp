<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#navVarun a:link, a:visited {
    background-color: black;
    color: white;
    padding: 14px 25px;
    text-align: center;	
    text-decoration: none;
    display: inline-block;
    width:100px;
    height:15px;
    border-style: groove;
    font-family:Monospace;
}


#navVarun a:hover, a:active {
    background-color: orange;
}
</style>
</head>
<body>
<%
HttpSession navsession	= request.getSession();	
String typeNav=(String)navsession.getAttribute("type");
boolean isStaffNav=false;
boolean isStudentNav=false;
boolean isFacultyNav=false;
if(typeNav.equals("staff"))
	isStaffNav=true;

if(typeNav.equals("student"))
	isStudentNav=true;

if(typeNav.equals("faculty"))
	isFacultyNav=true;
%>

<div class="navVarun" id="navVarun">
<a href="home.jsp">Home</a>
<a href="ReserveResource.jsp">Reserve</a>
<a href="CancelResourceServlet">Cancel</a>
<%if(!isStaffNav){ %>
<a href="DisplayCourseInfo">Course Info</a>
<%} %>
<a href="DisplayDiscoServlet">Dicsco</a>
<a href="DisplayAnncServlet">Announcement</a>
<a href="DisplayPhd">Phd</a>
<a href="DisplayExamServlet">Exam</a>
<a href="DisplayAlumniServlet">Alumni</a>
<a href="Profile.jsp">Edit Profile</a>
<%if(isStudentNav){ %>
<a href="sendEmailServlet">Send Email</a>
<a href="joblistServlet">Apply Job</a>
<%} %>

</div>


</body>
</html>