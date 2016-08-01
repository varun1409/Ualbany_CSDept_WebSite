package csdept;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddQuestionServlet
 */
public class AddQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddQuestionServlet() {
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
		doGet(request, response);
		
		String qtitle=request.getParameter("qtitle");
		String qcontent=request.getParameter("qcontent");
		Date date=new Date();
		int pid=0;
	//	java.sql.Timestamp sqlDate = new java.sql.Timestamp(date);
		HttpSession session	= request.getSession();	
		//String profName=(String)session.getAttribute("fname");
		String email=(String)session.getAttribute("email");
		DiscoDAO dao=new DiscoDAO();
		dao.insertPost(qtitle, qcontent, email, date, pid);
		
		 request.getRequestDispatcher("DisplayDiscoServlet").forward(request, response);
		 
		 
		
	}

}
