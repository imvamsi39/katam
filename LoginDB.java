package com.katamDB;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB {
	String url = "jdbc:mysql://localhost:3308/bwi";
	String uname = "root";
	String pass = "123456";

	/*
	 * Class.forName("com.mysql.jdbc.Driver"); Connection
	 * con=DriverManager.getConnection(url,uname,pass);
	 */

	public boolean checkCred(String Uid, String pswd) throws ClassNotFoundException, SQLException {
		/*
		 * String url="jdbc:mysql://localhost:3308/bwi"; String uname="root"; String
		 * pass="123456";
		 */ 
		  Class.forName("com.mysql.jdbc.Driver"); 
		  Connection con=DriverManager.getConnection(url,uname,pass);
		 

		String sql = "select * from login";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		String userName = rs.getString("userId");
		String passWord = rs.getString("pwd");

		if (userName.equals(Uid) && passWord.equals(pswd)) {
			return true;
		} else {
			return false;
		}

	}
	
	public void insert(String Uid,String pwd,String name,String mail,String gender,int age,String city,String state) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver"); 
		Connection con=DriverManager.getConnection(url,uname,pass);
		 

		String sql ="insert into users values('"+name+"','"+mail+"','"+gender+"','"+age+"','"+city+"','"+state+"','"+Uid+"','"+pwd+"')";
		String sql2="insert into login values('"+Uid+"','"+pwd+"')";
		Statement st = con.createStatement();
		int rs = st.executeUpdate(sql);
		int rs2=st.executeUpdate(sql2);
		
		if(rs==1)
		{
			System.out.println("inserted");
		}
		else
		{
			System.out.println("not insreted");
		}
	}

}
