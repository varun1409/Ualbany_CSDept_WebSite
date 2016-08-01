package csdept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReserveDAO {

	
	public ArrayList<Reservation> getSlotDetails(String date,String rtype)
	{
		ArrayList<Reservation> resArray = new ArrayList<Reservation>();
		
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="select ra.date,ra.slot1,ra.slot2,ra.slot3,ra.slot4,ra.slot5,ra.slot6,ra.slot7,ra.slot8,r.rname,r.rdesc,r.rtype from ravailability ra,resources r where r.rid=ra.rid and r.rtype=? and ra.date=?;";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, rtype);
		preparedStmt.setString(2, date);
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			Reservation res=new Reservation();
			res.setRdate(rs.getString("date"));
			res.setRname(rs.getString("rname"));
			res.setRtype(rs.getString("rtype"));
			res.setRdesc(rs.getString("rdesc"));
			res.setSlot1(rs.getBoolean("slot1"));
			res.setSlot2(rs.getBoolean("slot2"));
			res.setSlot3(rs.getBoolean("slot3"));
			res.setSlot4(rs.getBoolean("slot4"));
			res.setSlot5(rs.getBoolean("slot5"));
			res.setSlot6(rs.getBoolean("slot6"));
			res.setSlot7(rs.getBoolean("slot7"));
			res.setSlot8(rs.getBoolean("slot8"));
			
			resArray.add(res);
		}
		
		
		for(int i=0;i<resArray.size();i++)
		{
			String dt=resArray.get(i).getRdate();
			String resName=resArray.get(i).getRname();
			ArrayList<String> al=new ArrayList<String>();
			for(int j=1;j<9;j++)
			{
				String sl="slot"+j;
				String sql2="select usermail from appt where resname=? and date=? and slot=?";
				PreparedStatement preparedStmt2 = con.prepareStatement(sql2);
				preparedStmt2.setString(1, resName);
				preparedStmt2.setString(2, dt);
				preparedStmt2.setString(3, sl);
				
				ResultSet rs2=preparedStmt2.executeQuery();
				if(rs2.next())
					al.add(rs2.getString("usermail"));
				else
					al.add("  ");
			}
			
			
			resArray.get(i).setSlot1Name(al.get(0));
			resArray.get(i).setSlot2Name(al.get(1));
			resArray.get(i).setSlot3Name(al.get(2));
			resArray.get(i).setSlot4Name(al.get(3));
			resArray.get(i).setSlot5Name(al.get(4));
			resArray.get(i).setSlot6Name(al.get(5));
			resArray.get(i).setSlot7Name(al.get(6));
			resArray.get(i).setSlot8Name(al.get(7));
			
		}
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println("Er" +e);
		}
		
		return resArray;
	}
	
	
	public void reserveResource(String email,String date, String slot,String resname)
	{
		String sql,sql1,sql2;
		int rid=30;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="Insert into appt(date,slot,usermail,resname)"+"values(?,?,?,?)";
		sql1="select rid from resources where rname=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setString(2, slot);
		preparedStmt.setString(3, email);
		preparedStmt.setString(4, resname);
		System.out.println(email.length());
		preparedStmt.execute();
		
		
		PreparedStatement preparedStmt2 = con.prepareStatement(sql1);
		preparedStmt2.setString(1, resname);
		System.out.println(email.length());
		ResultSet rs=preparedStmt2.executeQuery();
		if(rs.next())
		{
		rid=rs.getInt("rid");
		
		System.out.println("rid:"+rid);
		}
		sql2="update ravailability set "+slot+"=0 where date=? and rid=?;";
		PreparedStatement preparedStmt3 = con.prepareStatement(sql2);
		
		
		preparedStmt3.setString(1, date);
		preparedStmt3.setInt(2, rid);
		System.out.println(email.length());
		preparedStmt3.execute();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	
	public ArrayList<ResReserved> getAppointment(String email)
	{
		ArrayList<ResReserved> resArray=new ArrayList<ResReserved>();
		
		String sql;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="select * from appt where usermail=?;";
		
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, email);
		
		
		ResultSet rs=preparedStmt.executeQuery();
		while(rs.next())
		{
			ResReserved res=new ResReserved();
			res.setDate(rs.getString("date"));
			res.setEmail(rs.getString("usermail"));
			res.setId(rs.getInt("apptid"));
			res.setResName(rs.getString("resname"));
			res.setSlot(rs.getString("slot"));
			res.setTime(rs.getString("slot"));
			
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
	
	
	
	public boolean cancelReservation(String slot,String resname, String date,String email)
	{
		boolean s=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		String sql="Delete from appt where date=? and usermail=? and slot=? and resname=?;";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setString(2, email);
		preparedStmt.setString(3, slot);
		preparedStmt.setString(4, resname);
		
		 s=preparedStmt.execute();
		
		String sql1="select rid from resources where rname=?";
		int rid=30;
		PreparedStatement preparedStmt2 = con.prepareStatement(sql1);
		preparedStmt2.setString(1, resname);
		System.out.println(email.length());
		ResultSet rs=preparedStmt2.executeQuery();
		if(rs.next())
		{
		rid=rs.getInt("rid");
		
		System.out.println("rid:"+rid);
		}
		
		String sql2="update ravailability set "+slot+"=1 where date=? and rid=?;";
		PreparedStatement preparedStmt3 = con.prepareStatement(sql2);
		
		
		preparedStmt3.setString(1, date);
		preparedStmt3.setInt(2, rid);
		
		System.out.println(email.length());
		preparedStmt3.execute();
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return s;
		
	}
	
	
	public boolean AddResource(String type, String name, String desc )
	{
		boolean s=false;
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
		
		String sql="Insert into resources(rtype,rname,rdesc)"+"values(?,?,?)";
		PreparedStatement preparedStmt3 = con.prepareStatement(sql);
		
		
		preparedStmt3.setString(1, type);
		preparedStmt3.setString(2, name);
		preparedStmt3.setString(3, desc);
		
		s=preparedStmt3.execute();
		
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return s;
	}


	public boolean checkReserve(String date, String slot, String resname) {
		// TODO Auto-generated method stub
		boolean isReserved= false;
		String sql,sql1,sql2;
		
		try
		{
		Connection con=null;
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/termproject", "root", "virgo");
	
		sql="select * from appt where date=? and slot=? and resname=?";
		
		
		PreparedStatement preparedStmt = con.prepareStatement(sql);
		preparedStmt.setString(1, date);
		preparedStmt.setString(2, slot);

		preparedStmt.setString(3, resname);

		ResultSet rs=preparedStmt.executeQuery();
		
		if(rs.next())
			isReserved=true;
		
		
		con.close();
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return isReserved;
	}
}
