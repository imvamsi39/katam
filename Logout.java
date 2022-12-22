package com.katamLeo;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		HttpSession session= request.getSession();
		//out.println(session.getId());
		
		
		if(session.getAttribute("userSes")==null)
		{
			response.sendRedirect("Login.html");
		}
		else {
		session.removeAttribute("userSes");
		session.invalidate();
		RequestDispatcher rd= request.getRequestDispatcher("Login.html");
		response.setContentType("text/html");
		out.println("<h4 style='color:yellow';>Visit again</h4>");
		rd.include(request, response);
		}
		//response.sendRedirect("Login.html");
		
		
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
