package csdept;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class AlumniDAO {
	
	
	public boolean insertAlumni(String name,String link,String details)
	{
		boolean ins=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		
		
		
		 sql="Insert into alumni(name,link,details)"+"values(?,?,?)";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, link);
		preparedStmt.setString(3, details);


		ins=preparedStmt.execute();
		
		
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return ins;
	}

	public ArrayList<Alumni> getAlumniDetails() {
		// TODO Auto-generated method stub
		ArrayList<Alumni> arr=new ArrayList<Alumni>();
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		
		String sql;
		
		
		
		 sql="select * from alumni";
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Alumni a=new Alumni();
			a.setId((rs.getInt("id")));
			a.setName(rs.getString("name"));
			a.setLinks(rs.getString("link"));
			a.setDetails(rs.getString("details"));
		
			
			arr.add(a);
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return arr;
	}

	public boolean UpdateAlumniInfo(int id, String link, String details, String name) {
		// TODO Auto-generated method stub
		String sql;
		boolean upd=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Update alumni set name=?,details=?,link=? where id=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		
		preparedStmt.setString(1, name);
		preparedStmt.setString(2, details);
		preparedStmt.setString(3, link);
		preparedStmt.setInt(4, id+1);
		upd=preparedStmt.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return upd;
	}
	

}
