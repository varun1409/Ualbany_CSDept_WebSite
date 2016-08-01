package csdept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PhdDAO {

	

	public ArrayList<Phd> getPhdDetails()
	{
		ArrayList<Phd> resArray = new ArrayList<Phd>();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Select * from  phd";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Phd res=new Phd();
			res.setName(rs.getString("name"));
			res.setEmail(rs.getString("email"));
			res.setIsCandidate(rs.getString("isCandidate"));
			res.setProgram(rs.getString("program"));
			res.setMajor(rs.getString("major"));
			res.setYoj(rs.getString("yoj"));
			
			
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
	
	public boolean UpdatePhdStatus(String email,String val)
	{
		String sql;
		boolean flag=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Update phd set isCandidate=? where email=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		preparedStmt.setString(1, val);
		preparedStmt.setString(2, email);
		flag=preparedStmt.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return flag;
	}
	
}
