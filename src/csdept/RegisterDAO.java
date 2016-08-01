package csdept;
import java.sql.*;

public class RegisterDAO {

	public boolean emailCheck(String email)
	{
		String sql;
		boolean isExist=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="select * from user where email=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, email);
		
		ResultSet rs=preparedStmt.executeQuery();
		if(rs.next())
			isExist=true;
		else
			isExist=false;
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return isExist;
	}
	
	public void insertUser(user u)
	{
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb:3306","dochubse","dochubse");
		
		String sql="Insert into user(fname,lname,email,password,type,phone,program,yoj,major,advisor,address)"+"values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, u.getFname());
		preparedStmt.setString(2, u.getLname());
		preparedStmt.setString(3, u.getEmail());
		preparedStmt.setString(4, u.getPassword());
		preparedStmt.setString(5, u.getUser_type());
		preparedStmt.setString(6, u.getPhone());
		preparedStmt.setString(7,u.getProgram());
		preparedStmt.setString(8,u.getYoj());
		preparedStmt.setString(9,u.getMajor());
		preparedStmt.setString(10, u.getAdvisor());
		preparedStmt.setString(11, u.getAddress());
		
		preparedStmt.execute();
	    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public void insertPhd(user u)
	{
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		//con=DriverManager.getConnection("jdbc:mysql://dochub.co22bzlmbxnt.us-west-2.rds.amazonaws.com/dochubdb:3306","dochubse","dochubse");
		
		String sql="Insert into phd(name,isCandidate,yoj,program,major,email)"+"values(?,?,?,?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, u.getFname()+" "+u.getLname());
		preparedStmt.setString(2, "No");
		preparedStmt.setString(6, u.getEmail());
		preparedStmt.setString(5,u.getProgram());
		preparedStmt.setString(3,u.getYoj());
		preparedStmt.setString(4,u.getMajor());
		
		preparedStmt.execute();
	    con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public void updateProfile(String email, String phone, String address, String advisor) {
		// TODO Auto-generated method stub
		String sql;
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		System.out.println(address);
		sql="Update user set phone=?,address=?,advisor=? where email=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, phone);
		preparedStmt.setString(2, address);
		preparedStmt.setString(3, advisor);
		preparedStmt.setString(4, email);
		
		preparedStmt.execute();
		
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
}



