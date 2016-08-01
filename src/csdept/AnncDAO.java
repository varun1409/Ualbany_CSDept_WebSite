package csdept;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnncDAO {

	
	public boolean updateAnnouncement(int id,String title,String details,String links)
	{
		boolean upd=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		sql="Update announcement set alinks=?,atitle=?,adetails=? where id=?;";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		preparedStmt.setString(2, title);
		preparedStmt.setString(3, details);
		preparedStmt.setString(1, links);
		preparedStmt.setInt(4, id);

		upd=preparedStmt.execute();
		
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return upd;

	}
	
	
	public boolean insertAnnouncement(String type,String title,String details,String links, String email)
	{
		boolean ins=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		
		
		
		 sql="Insert into announcement(atype,atitle,adetails,alinks,email)"+"values(?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, type);
		preparedStmt.setString(2, title);
		preparedStmt.setString(3, details);
		preparedStmt.setString(4, links);
		preparedStmt.setString(5, email);

		 ins=preparedStmt.execute();
		
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ins;
	}
	
	public ArrayList<Announcement> getAnncDetails()
	{
		ArrayList<Announcement> arr=new ArrayList<Announcement>();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		
		
		
		 sql="select * from announcement";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Announcement a=new Announcement();
			a.setId(rs.getInt("id"));
			a.setType(rs.getString("atype"));
			a.setTitle(rs.getString("atitle"));
			a.setDetails(rs.getString("adetails"));
			a.setLinks(rs.getString("alinks"));
			a.setEmail(rs.getString("email"));
			
			arr.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arr;
	}
	
	
	public boolean deleteAnnc(String id)
	{
		
		boolean del=false;
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		//System.out.println("defore dele:"+id);
		sql="Delete from announcement where id=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, id);
		
		
		 del=preparedStmt.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return del;
	}
	
	public Announcement getAnncInfo(String id)
	{
		Announcement res = new Announcement();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  announcement where id=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, id);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			//Course res=new Course();
			res.setId(rs.getInt("id"));
			res.setType(rs.getString("atype"));
			res.setTitle(rs.getString("atitle"));
			res.setDetails(rs.getString("adetails"));
			res.setLinks(rs.getString("alinks"));
			res.setEmail(rs.getString("email"));
			//res.setTa(rs.getString("tadetails"));
			//res.setSyllabus(rs.getBlob("syllabus"));
			
			
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}


	public ArrayList<Announcement> getJobList() {
		// TODO Auto-generated method stub
		ArrayList<Announcement> jobs=new ArrayList<Announcement>();
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  announcement where atype=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, "job");
		
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			//Course res=new Course();
			Announcement res=new Announcement();
			res.setId(rs.getInt("id"));
			res.setType(rs.getString("atype"));
			res.setTitle(rs.getString("atitle"));
			res.setDetails(rs.getString("adetails"));
			res.setLinks(rs.getString("alinks"));
			res.setEmail(rs.getString("email"));
			//res.setTa(rs.getString("tadetails"));
			//res.setSyllabus(rs.getBlob("syllabus"));
			jobs.add(res);
			
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return jobs;
	}
	
}
