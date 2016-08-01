package csdept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MakeReservationServlet
 */
public class MakeReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeReservationServlet() {
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
		System.out.println(useremail);
		ReserveDAO dao=new ReserveDAO();
		boolean isReserved=dao.checkReserve(date,slot,resname);
		System.out.println(isReserved);
		String msg;
		if(!isReserved)
		{
		dao.reserveResource(useremail,date,slot,resname);
		msg="Booking Successful. Thank You!";
		}
		else
		msg="Somebody already booked the requested slot.Sorry!";
		
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("ReserveResource.jsp").forward(request, response);
		
		
	}

}
