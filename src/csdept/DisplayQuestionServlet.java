package csdept;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayQuestionServlet
 */
public class DisplayQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("hlljj");
		int postid=Integer.parseInt(request.getParameter("postid"));
		DiscoDAO dao=new DiscoDAO();
		DicsoInfo ques=dao.getPostInfo(postid);
		ArrayList<DicsoInfo> rep=dao.getReplies(postid);
		
		request.setAttribute("ques", ques);
		request.setAttribute("rep", rep);
		 request.getRequestDispatcher("Post.jsp").forward(request, response);
		
		
		
	}

}
