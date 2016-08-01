package csdept;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddResultsServlet
 */
public class AddResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddResultsServlet() {
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
		String etitle=request.getParameter("etitle");
		String esemester=request.getParameter("esemester");
		String econtent="Exam Results will be posted soon.";
		String edate=request.getParameter("edate");
		//Date date=new Date();
		
	//	java.sql.Timestamp sqlDate = new java.sql.Timestamp(date);
		HttpSession session	= request.getSession();	
		//String profName=(String)session.getAttribute("fname");
		String email=(String)session.getAttribute("email");
		ExamDAO dao=new ExamDAO();
		dao.insertResults(etitle, econtent, email, esemester,edate );
		
		 request.getRequestDispatcher("DisplayExamServlet").forward(request, response);
		 
	}

}
