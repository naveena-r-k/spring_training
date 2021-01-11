package com.zensar;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoController extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		String requestAction=request.getParameter("requestAction");
		if (requestAction.equalsIgnoreCase("login")) {
			
			String userName=request.getParameter("userName");
			String password=request.getParameter("password");
			System.out.println(userName+":"+password);
			DemoRepository demo= new DemoRepository();
			boolean result=demo.validateLogin(userName, password);
			if (result) {
				try {
					response.sendRedirect("HomePage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Exception occured:"+e);
				}
			} 
			else {
				request.setAttribute("errormsg", "Invalid");
				RequestDispatcher rd= request.getRequestDispatcher("Login.jsp");
				try {
					rd.forward(request, response);
				} catch (Exception e) {
					System.out.println("Exception occured:"+e);

				} 
			}
		}
		else if(requestAction.equalsIgnoreCase("logout")) {
			try {
				request.setAttribute("logoutmsg", "logout");
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				System.out.println("Exception occured:"+e);
			}
		}
	}
	
}
