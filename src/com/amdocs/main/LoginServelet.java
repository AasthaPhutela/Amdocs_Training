package com.amdocs.main;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck=new Cookie("user_id","");
		response.addCookie(ck);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("loginid");
		String password = request.getParameter("password");
				
		try {
			login LU = new login(userid , password);
			Cookie ck;
			switch(LU.loginUser()) {
				case 0:
					ck= new Cookie("user_id",userid);
					response.addCookie(ck);
					
					response.sendRedirect("user");
				    break;
				 case 1:
					 ck= new Cookie("user_id",userid);
					 response.addCookie(ck);
					 
					 response.sendRedirect("admin");
				    break;
				 default:
					 response.sendRedirect("login");  
			}
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("register");
		}

	}

}