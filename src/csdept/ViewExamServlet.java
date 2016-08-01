package csdept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewExamServlet
 */
public class ViewExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewExamServlet() {
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
		int eid=Integer.parseInt(request.getParameter("eid"));
		ExamDAO dao=new ExamDAO();
		ExamInfo e=dao.getExam(eid);
		
		String type=(String)request.getSession().getAttribute("type");
		if(type.equals("student"))
		{
			String email=(String)request.getSession().getAttribute("email");
			boolean isReg=dao.isRegistered(eid,email);
			request.setAttribute("isReg", isReg);
		}
		System.out.println(e.getEname());
		
		request.setAttribute("e", e);
		request.getRequestDispatcher("ViewExam.jsp").forward(request, response);
	}

}
