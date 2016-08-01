package csdept;

import java.io.IOException;
import java.io.*;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cid=request.getParameter("cid");
		System.out.println(cid);
		CourseDAO dao=new CourseDAO();
		Blob file=dao.getSyllabus(cid);
		System.out.println(file);
		//Blob file=null;
		byte[ ] fileData = null ;
			//file=c.get(i).getSyllabus();
			try {
				fileData = file.getBytes(1,(int)file.length());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Hello");
				e.printStackTrace();
			}
			response.setContentType("application/pdf");
		    response.setHeader("Content-Disposition", "inline");
		    response.setContentLength(fileData.length);
		    
		   OutputStream output2 = response.getOutputStream();
		   output2.write(fileData);
		    output2.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	

}
