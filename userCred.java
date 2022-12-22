package com.katamDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Servlet implementation class userCred
 */
public class userCred extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param String 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String Uid=request.getParameter("Uid");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String mail=request.getParameter("mail");
		String gender=request.getParameter("gender");
		int age =Integer.parseInt(request.getParameter("age"));
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		
		PrintWriter out=response.getWriter();
		out.println(Uid+" "+pwd+" "+name+" "+mail+" "+gender+" "+age+" "+city+" "+state);
		
		LoginDB userDetails=new LoginDB();
		
		try 
		{
			userDetails.insert(Uid,pwd,name,mail,gender,age,city,state);
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

}
