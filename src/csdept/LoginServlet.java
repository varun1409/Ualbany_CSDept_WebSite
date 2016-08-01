package csdept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		LoginDAO dao=new LoginDAO();
		boolean isValid= dao.isValidUser(email, password);
		
		if(isValid)
		{
			System.out.println("Success");
			user u=dao.getUserDetails(email);
			HttpSession session	= request.getSession();	
			session.setAttribute("fname",u.getFname());
			session.setAttribute("lname",u.getLname());
			session.setAttribute("email",u.getEmail());
			session.setAttribute("password",u.getPassword());
			session.setAttribute("type",u.getUser_type());
			session.setAttribute("phone",u.getPhone());
			session.setAttribute("id",u.getId());
			session.setAttribute("advisor", u.getAdvisor());
			session.setAttribute("address", u.getAddress());
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else
		{
			String msg="Email address or Password is incorrect";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

}
