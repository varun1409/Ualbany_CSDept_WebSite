package csdept;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyServlet() {
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
		String reply=request.getParameter("reply");
		System.out.println(request.getParameter("reply"));
		System.out.println(request.getParameter("postid"));
		int pid=Integer.parseInt(request.getParameter("postid"));
		Date date=new Date();
		String qtitle=null;
	//	java.sql.Timestamp sqlDate = new java.sql.Timestamp(date);
		HttpSession session	= request.getSession();	
		//String profName=(String)session.getAttribute("fname");
		String email=(String)session.getAttribute("email");
		DiscoDAO dao=new DiscoDAO();
		dao.insertPost(qtitle, reply, email, date, pid);
		

		 request.getRequestDispatcher("DisplayQuestionServlet?postid="+pid).forward(request, response);
		 
	}

}
