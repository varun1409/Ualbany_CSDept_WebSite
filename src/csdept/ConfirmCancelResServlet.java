package csdept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ConfirmCancelResServlet
 */
public class ConfirmCancelResServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfirmCancelResServlet() {
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
		HttpSession session	= request.getSession();	
		String slot=request.getParameter("slot");
		String resname=request.getParameter("resname");
		String date=request.getParameter("date");
		String useremail=(String)session.getAttribute("email");
		
		ReserveDAO dao=new ReserveDAO();
		dao.cancelReservation(slot,resname,date,useremail);
		
		ArrayList<ResReserved> resRes=new ArrayList<ResReserved>(); 
		resRes=dao.getAppointment(useremail);
		
		request.setAttribute("res", resRes);
		
		request.getRequestDispatcher("CancelResource.jsp").forward(request, response);
	}

}
