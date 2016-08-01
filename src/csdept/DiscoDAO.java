package csdept;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class DiscoDAO {

	public boolean insertPost(String qtitle,String qcontent,String email,Date d,int pid)
	{
		boolean s=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		String sql2="Insert into post(qtitle,qcontent,usermail, dt,pid)"+"values(?,?,?,?,?)";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setString(1, qtitle);
		preparedStmt2.setString(2, qcontent);
		preparedStmt2.setString(3, email);
		preparedStmt2.setTimestamp(4, sqlDate);
		preparedStmt2.setInt(5, pid);
		
		s=preparedStmt2.execute();
		con.close();
		
				
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
	}
	
	public ArrayList<DicsoInfo> discoInfo()
	{
		ArrayList<DicsoInfo> arr=new ArrayList<DicsoInfo>();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		String sql2="select * from post  where pid=0 order by dt desc";
		
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		//preparedStmt2.setInt(1, 0);
		
		ResultSet rs=preparedStmt2.executeQuery();
		
		
		while(rs.next())
		{
			DicsoInfo res=new DicsoInfo();
			res.setPostid(rs.getInt("qid"));
			res.setPcontent(rs.getString("qcontent"));
			res.setUsermail(rs.getString("usermail"));
			res.setPtitle(rs.getString("qtitle"));
			res.setPid(rs.getInt("pid"));
			
			res.setTime(rs.getTimestamp("dt"));
			
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
	
	

	public DicsoInfo getPostInfo(int postid)
	{
		DicsoInfo res=new DicsoInfo();
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		String sql2="select * from post where qid=?";
		String sql3="select * from post where pid=? order by dt desc";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setInt(1, postid);
		
		ResultSet rs=preparedStmt2.executeQuery();
		//ResultSet rs=preparedStmt2.executeQuery();
		
		
		if(rs.next())
		{
			
			res.setPostid(rs.getInt("qid"));
			res.setPcontent(rs.getString("qcontent"));
			res.setUsermail(rs.getString("usermail"));
			res.setPtitle(rs.getString("qtitle"));
			res.setPid(rs.getInt("pid"));
			
			res.setTime(rs.getTimestamp("dt"));
			
			
		}
		con.close();	
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return res;
		}
	
	public ArrayList<DicsoInfo> getReplies(int postid)
	{
		ArrayList<DicsoInfo> arr=new ArrayList<DicsoInfo> ();
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		//String sql2="select * from post where qid=?";
		String sql2="select * from post where pid=? order by dt";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setInt(1, postid);
		
		ResultSet rs=preparedStmt2.executeQuery();
		//ResultSet rs=preparedStmt2.executeQuery();
		
		
		while(rs.next())
		{
			DicsoInfo res=new DicsoInfo();
			res.setPostid(rs.getInt("qid"));
			res.setPcontent(rs.getString("qcontent"));
			res.setUsermail(rs.getString("usermail"));
			res.setPtitle(rs.getString("qtitle"));
			res.setPid(rs.getInt("pid"));
			
			res.setTime(rs.getTimestamp("dt"));
			
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

	
	public void deletePost(int id) {
		// TODO Auto-generated method stub
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		//String sql2="select * from post where qid=?";
		String sql2="Delete from post where qid=?";
		String sql="Delete from post where pid=?";
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt2.setInt(1, id);
		preparedStmt.setInt(1, id);
		preparedStmt2.execute();
		preparedStmt.execute();
		
		
		con.close();	
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
	
	
	public void deleteReply(int id) {
		// TODO Auto-generated method stub
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		//String sql2="select * from post where qid=?";
		String sql2="Delete from post where qid=?";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		
		preparedStmt2.setInt(1, id);
		
		preparedStmt2.execute();
		
		
		
		con.close();	
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		}
	
	
	public int getParentid(int id)
	{
		int pid=0;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		//java.sql.Timestamp sqlDate = new java.sql.Timestamp(d.getTime());
		//String sql2="select * from post where qid=?";
		String sql2="select pid from post where qid=?";
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		
		preparedStmt2.setInt(1, id);
		
		ResultSet rs=preparedStmt2.executeQuery();
		while(rs.next())
		{
			pid=rs.getInt("pid");
		}
		con.close();	
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return pid;
	}
}
