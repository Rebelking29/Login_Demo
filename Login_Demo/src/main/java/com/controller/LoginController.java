package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.dao.Loginimp;
import com.pojo.Login;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Loginimp logimp = new Loginimp();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		String username = request.getParameter("username");
		String pass = request.getParameter("upass");
		String action = request.getParameter("action");
		
		if(action != null && action.equals("login")) {
			
			Login log = logimp.loginSuccess(username);
			
			if(log != null) {
					
			 boolean check1 = log.getPassword().equals(pass);
			 boolean check2 = log.getUsername().equals(username);
			 
			 if(check1 && check2) {
				 
				 response.sendRedirect("logincontroller");
			 }else {
				 response.getWriter().print("Invalid Password");
				 request.getRequestDispatcher("Login.html").include(request, response);
			 }
			 
			}else {
				response.getWriter().print("Invalid user credintials");
				request.getRequestDispatcher("Login.html").include(request, response);
			}
			
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		
		String action = req.getParameter("action");
		
		if(action == null) {
			resp.sendRedirect("Welcome.html");
		}
	}

}
