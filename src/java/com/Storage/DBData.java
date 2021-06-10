package com.Storage;

import com.bean.SignupBean;
import com.configuration.GetConnection;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBData {

    public static int newBidder(SignupBean sb) {
       // int i = 0;
        int status=0;
        try {
            Connection con = GetConnection.TakeConnection();
            String query ="insert into bidder(name,occupation,networth,location,mobile,password,email)values(?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, sb.getName());
         
            ps.setString(2, sb.getOccupation());
            ps.setString(3, sb.getNetworth());
            ps.setString(4, sb.getLocation());
            ps.setString(5, sb.getMobile());
            ps.setString(6, sb.getPassword());
            ps.setString(7, sb.getEmail());
            status=ps.executeUpdate();
            System.out.println("the status is "+status);
           // con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }
    
    
    
    
    public static String checkLogin(SignupBean sb)
	{
		Connection con = null;
		try
		{
			con = GetConnection.TakeConnection();
			String query = "select * from bidder where email=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,sb.getEmail());
			ps.setString(2,sb.getPassword());

			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				return "true";
			}
			else
			{
				return "false";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "error";
	}
	public static int getBidderId(String email)
	{
		int  id=0;
		Connection con = null;
		try
		{
			con = GetConnection.TakeConnection();
			String query = "select b_id from bidder where email=? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				id = rs.getInt(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
	
	public static String getBidderName(String email)
	{
		String  name="";
		Connection con = null;
		try
		{
			con = GetConnection.TakeConnection();
			String query = "select name from bidder where email=? ";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,email);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				name = rs.getString(1);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return name;
	}
	
	
      
}
