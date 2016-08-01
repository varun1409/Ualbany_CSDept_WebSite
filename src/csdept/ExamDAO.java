package csdept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ExamDAO {

	
	public void insertResults(String etitle,String econtent,String email,String esemester,String edate)
	{
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql2="Insert into exam(usermail,exam_name,semester,exam_content,exam_date)"+"values(?,?,?,?,?)";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setString(1, email);
		preparedStmt2.setString(2, etitle);
		preparedStmt2.setString(3, esemester);
		preparedStmt2.setString(4, econtent);
		preparedStmt2.setString(5, edate);
		preparedStmt2.execute();
		con.close();
		
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<ExamInfo> getExamList()
	{
		ArrayList<ExamInfo> arr=new ArrayList<ExamInfo>();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		String sql2="select * from exam";
		
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		//preparedStmt2.setInt(1, 0);
		
		ResultSet rs=preparedStmt2.executeQuery();
		
		
		while(rs.next())
		{
			ExamInfo res=new ExamInfo();
			res.setEid((rs.getInt("id")));
			res.setEname(rs.getString("exam_name"));
			res.setEcontent(rs.getString("exam_content"));
			res.setEsemester(rs.getString("semester"));
			res.setEmail(rs.getString("usermail"));
			res.setEdate(rs.getString("exam_date"));
			
			arr.add(res);
		}
		con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arr;
		}
	
	
	public ExamInfo getExam(int id)
	{
		ExamInfo res=new ExamInfo();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		String sql2="select * from exam where id=?";
		
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setInt(1, id);
		
		ResultSet rs=preparedStmt2.executeQuery();
		
		
		while(rs.next())
		{
			
			res.setEid((rs.getInt("id")));
			res.setEname(rs.getString("exam_name"));
			res.setEcontent(rs.getString("exam_content"));
			res.setEsemester(rs.getString("semester"));
			res.setEmail(rs.getString("usermail"));
			res.setEdate(rs.getString("exam_date"));
			
			
		}
		con.close();	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
		
	}

	public void updateExam(int id, String content) {
		// TODO Auto-generated method stub
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		sql="Update exam set exam_content=? where id=?;";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		
		preparedStmt.setString(1, content);
		preparedStmt.setInt(2, id);

		preparedStmt.execute();
		
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}

	public void deleteExam(String id) {
		// TODO Auto-generated method stub

		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		//System.out.println("defore dele:"+id);
		sql="Delete from exam where id=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, id);
		
		
		preparedStmt.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}

	public void registerExam(String id, String email) {
		// TODO Auto-generated method stub

		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql2="Insert into studentExam(eid,sid)"+"values(?,?)";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setString(2, email);
		preparedStmt2.setString(1, id);
	
		preparedStmt2.execute();
		con.close();
		
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
	}

	public boolean isRegistered(int eid, String email) {
		// TODO Auto-generated method stub
		boolean isRegister=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql2="select * from studentExam where eid=? and sid=?";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setString(2, email);
		preparedStmt2.setInt(1, eid);
		ResultSet rs=preparedStmt2.executeQuery();
		if(rs.next())
		{
			isRegister=true;
		}
		
		con.close();
		
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		return isRegister;
	}
	
}
