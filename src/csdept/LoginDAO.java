package csdept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

	public boolean isValidUser(String email, String password)
	{
		String sql;
		boolean isExist=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="select * from user where email=? and password=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, email);
		preparedStmt.setString(2, password);
		
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
	
	
	public user getUserDetails(String email)
	{
		user user=new user();
		String sql;
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
		{
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setUser_type(rs.getString("type"));
			user.setId(rs.getInt("id"));
			user.setAdvisor(rs.getString("advisor"));
			user.setAddress(rs.getString("address"));
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return user;
	}
	
	
}
