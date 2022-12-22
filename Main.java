package com.katamDB;

import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		// TODO Auto-generated method stub

		LoginDB login=new LoginDB();
		
		System.out.println(login.checkCred("bhanu","vamsi2028"));
		
	}

}
