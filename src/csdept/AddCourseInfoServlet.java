package csdept;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
/**
 * Servlet implementation class AddCourseInfoServlet
 */
public class AddCourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String varun=request.getParameter("varun");
		
		String cname=request.getParameter("cname");
		String cid=request.getParameter("cid");
		String sem=request.getParameter("sem");
		String OffLoc=request.getParameter("OffLoc");
		String OffHours=request.getParameter("offHours");
		String ta=request.getParameter("ta");
		String taemail=request.getParameter("taemail");
		
		HttpSession session	= request.getSession();	
		//String profName=(String)session.getAttribute("fname");
		String profEmail=(String)session.getAttribute("email");
		InputStream inputStream = null;
		
		
		Part syllabus = request.getPart("syllabus");
		
		if (syllabus != null) 
        {
		 inputStream = syllabus.getInputStream();
		 System.out.println(syllabus.getName());
         System.out.println(syllabus.getSize());
         System.out.println(syllabus.getContentType());
        }
		 CourseDAO dao=new CourseDAO();
		 String profaddress=dao.getEmailFromNetId(profEmail);
		 dao.insertCourseInfo(inputStream, cid, cname,sem, OffLoc, OffHours, ta,taemail,profaddress, profEmail);
		 
		 request.getRequestDispatcher("DisplayCourseInfo").forward(request, response);
		 
		 
	}

}
