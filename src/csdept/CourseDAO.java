package csdept;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CourseDAO {

	public void insertCourseInfo(InputStream syllabus,String cid,String cname,String semester,String OffLoc, String OffHours,String ta,String taemail,String profaddress,String profEmail)
	{
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql2="select * from course where courseId=?";
		System.out.println("Vrun:"+cid);
		PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
		preparedStmt2.setString(1, cid);
		String sql;
		ResultSet rs=preparedStmt2.executeQuery();
		int row;
		if(rs.next())
		{
			sql="Update course set courseName=?,semester=?,profEmail=?,OfficeHours=?,OfficeLoc=?,tadetails=?,taemail=? where courseId=?";
			PreparedStatement preparedStmt = con.prepareStatement(sql);
			
			preparedStmt.setString(1, cname);
			preparedStmt.setString(2, semester);
			preparedStmt.setString(3, profEmail);
			preparedStmt.setString(4, OffHours);
			preparedStmt.setString(5, OffLoc);
			preparedStmt.setString(6, ta);
			//preparedStmt.setBlob(7,syllabus);
			preparedStmt.setString(7, taemail);
			preparedStmt.setString(8, cid);
			 row = preparedStmt.executeUpdate();
		}
		
		else
		{
		 sql="Insert into course(courseId,courseName,semester,profEmail,OfficeHours,OfficeLoc,tadetails,taemail,profaddress,syllabus)"+"values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, cid);
		preparedStmt.setString(2, cname);
		preparedStmt.setString(3, semester);
		preparedStmt.setString(4, profEmail);
		preparedStmt.setString(5, OffHours);
		preparedStmt.setString(6, OffLoc);
		preparedStmt.setString(7, ta);
		preparedStmt.setString(8, taemail);
		preparedStmt.setString(9, profaddress);
		preparedStmt.setBlob(10, syllabus);
		 row = preparedStmt.executeUpdate();
		}
		
		
        if (row > 0) {
            System.out.println("File uploaded and saved into database");
        }
		
		
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public ArrayList<Course> getCourseDetails(String email)
	{
		ArrayList<Course> resArray = new ArrayList<Course>();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  course where profEmail=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, email);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Course res=new Course();
			res.setCid(rs.getString("courseId"));
			res.setCname(rs.getString("courseName"));
			res.setSemester(rs.getString("semester"));
			res.setProfEmail(email);
			res.setOfficeHours(rs.getString("officeHours"));
			res.setOfficeLoc(rs.getString("officeLoc"));
			res.setTa(rs.getString("tadetails"));
			res.setSyllabus(rs.getBlob("syllabus"));
			
			resArray.add(res);
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return resArray;
	}
	
	public ArrayList<Course> getAllCourseDetails()
	{
		ArrayList<Course> resArray = new ArrayList<Course>();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  course";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Course res=new Course();
			res.setCid(rs.getString("courseId"));
			res.setCname(rs.getString("courseName"));
			res.setSemester(rs.getString("semester"));
			res.setProfEmail(rs.getString("profEmail"));
			res.setOfficeHours(rs.getString("officeHours"));
			res.setOfficeLoc(rs.getString("officeLoc"));
			res.setTa(rs.getString("tadetails"));
			res.setSyllabus(rs.getBlob("syllabus"));
			
			resArray.add(res);
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return resArray;
	}
	public Blob getSyllabus(String cid)
{
		String sql;
		Blob file=null;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select syllabus from course where courseId=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1,cid);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			file= rs.getBlob("syllabus");
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return file;
		
}
	
	public Course getCourseInfo(String cid)
	{
		Course res = new Course();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  course where courseId=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, cid);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		{
			//Course res=new Course();
			res.setCid(rs.getString("courseId"));
			res.setCname(rs.getString("courseName"));
			res.setSemester(rs.getString("semester"));
			res.setProfEmail(rs.getString("profEmail"));
			res.setOfficeHours(rs.getString("officeHours"));
			res.setOfficeLoc(rs.getString("officeLoc"));
			res.setTa(rs.getString("tadetails"));
			res.setSyllabus(rs.getBlob("syllabus"));
			
			
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return res;
	}
	
	public boolean deleteCourseInfo(String cid)
	{
		
		boolean b=false;
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		System.out.println("defore dele:"+cid);
		sql="Delete from course where courseId=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, cid);
		
		
		b=preparedStmt.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return b;
	}


	public String getEmailFromNetId(String profEmail) {
		// TODO Auto-generated method stub
		String sql;
		String addr="";
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		
		sql="select address from user where email=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, profEmail);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
		addr=rs.getString("address");
		con.close();
		System.out.println("Emai:"+addr);
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return addr;
	}


	public ArrayList<Course> getCourseEmails() {
		// TODO Auto-generated method stub
		String sql;
		ArrayList<Course> email=new ArrayList<Course>();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		
		sql="select courseId,courseName,taemail,profaddress from course";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		
		
		ResultSet rs=preparedStmt.executeQuery();
		
		while(rs.next())
		{
		Course c=new Course();
		c.setCid(rs.getString("courseId"));
		c.setCname(rs.getString("courseName"));
		c.setProfEmail(rs.getString("profaddress"));
		c.setTa(rs.getString("taemail"));
		
		email.add(c);
	
		}
		System.out.println("msil:::"+email.get(0).getProfEmail());
		System.out.println("msil:::"+email.get(0).getTa());
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return email;
	}
	
	
}
