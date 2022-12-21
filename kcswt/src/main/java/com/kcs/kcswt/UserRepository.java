package com.kcs.kcswt;


import java.util.*;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

import  java.sql.*;
public class UserRepository 
{
	
	Connection con=null;
	
	public UserRepository()
	{
		
		String url="jdbc:mysql://localhost: 3306/kcs";
		String username="root";
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,username);
		}
		catch(Exception e)
		{
			System.out.println("ERROR"+e);
		}
		
	}
	@GET
	@Path("userregistration/id")
	public List<Alien> getAlien()
	{
		List<Alien> aliens = new ArrayList<> ();
		String sql = "select * from user_registration;";
		try
		{
			Statement st=con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Alien a =new Alien();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setphone(rs.getInt(3));
				a.setaddress1(rs.getString(4));
				a.setaddress2(rs.getString(5));
				a.setpassword(rs.getString(6));
				aliens.add(a);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return aliens;
	}
	 private void createStatement() {
		// TODO Auto-generated method stub
		
	} 
	@POST
	@Path("userregistration")
	public void create(Alien a1) 
	{
		
		String sql="insert into user_registration values(?'?'?);";
		try
		{
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getphone());
			st.setString(4, a1.getaddress1());
			st.setString(5, a1.getaddress2());
			st.setString(6, a1.getpassword());
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		System.out.println("User created Successfully");
	}
	
}
