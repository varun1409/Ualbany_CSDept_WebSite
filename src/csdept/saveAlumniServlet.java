package csdept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class saveAlumniServlet
 */
public class saveAlumniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveAlumniServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("i"));
		String link=request.getParameter("link"+id);
		String details=request.getParameter("details"+id);
		String name=request.getParameter("name"+id);
		System.out.println(link);
		System.out.println(details);
		System.out.println(name);
		System.out.println(id);
		
		AlumniDAO dao=new AlumniDAO();
	
		dao.UpdateAlumniInfo(id,link,details,name);
		
		ArrayList<Alumni> al=dao.getAlumniDetails();
		request.setAttribute("al", al);
		 request.getRequestDispatcher("Alumni.jsp").forward(request, response);
	}

}
