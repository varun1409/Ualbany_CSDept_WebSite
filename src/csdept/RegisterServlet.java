package csdept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String user_type=request.getParameter("user_type");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		
		user user=new user();
		user.setEmail(email);
		user.setFname(fname);
		user.setLname(lname);
		user.setPassword(password);
		user.setPhone(phone);
		user.setUser_type(user_type);
		user.setAddress(address);
		user.setAdvisor("");
		user.setProgram("");
		user.setMajor("");
		user.setYoj("");
		
		if(user_type.equals("student"))
		{
			user.setMajor(request.getParameter("major"));
			user.setProgram(request.getParameter("program"));
			user.setYoj(request.getParameter("yoj"));
			
		}
		RegisterDAO dao=new RegisterDAO();
		
		boolean userAlreadyExist=dao.emailCheck(email);
		
		if(!userAlreadyExist)
		{
			dao.insertUser(user);
			if(user.getProgram().equals("PhD"))
			dao.insertPhd(user);
			System.out.println("User Created");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			String msg="Net Id already registered";
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
		
		
	}

}
