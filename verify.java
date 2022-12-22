package com.katamLeo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.katamDB.LoginDB;

/**
 * Servlet implementation class verify
 */
public class verify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user= request.getParameter("Uid");
		String pwd=request.getParameter("pwd");
		
		LoginDB login=new LoginDB();
		
		/*if(user.equals("vamsi39") && pwd.equals("vamsi.3394"))*/
		try {
			if(login.checkCred(user, pwd))
			{
				//RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp");
				//request.setAttribute("user",user);
				//request.setAttribute("pwd", pwd);
				
				HttpSession session= request.getSession();
				session.setAttribute("userSes", user);
				session.setAttribute("pwd", pwd);
				
				//rd.forward(request, response);	
				response.sendRedirect("welcome.jsp");
			}
			else
			{
				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
				response.setContentType("text/html");
				out.println("<h3 style='color:red';>Enter Correct Details</h3>");
				rd.include(request, response);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

}
