package csdept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReserveCheckServlet
 */
public class ReserveCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveCheckServlet() {
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
		String rtype=request.getParameter("r_type");
		String date=request.getParameter("datepicker");
		ReserveDAO dao=new ReserveDAO();
		
		ArrayList<Reservation> res=new ArrayList<Reservation>();
		res=dao.getSlotDetails(date, rtype);
		//System.out.println("Slot:"+res.get(0).isSlot1());
		//System.out.println("Name"+res.get(0).getSlot1Name());
		request.setAttribute("first", "first");
		request.setAttribute("date", date);
		request.setAttribute("res", res);
		request.getRequestDispatcher("ReserveResource.jsp").forward(request, response);
		
	}

}
