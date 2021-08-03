package com.amdocs.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminRegisterServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminRegisterServelet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("adminRegister.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>View Feedback</title>\r\n" + "<style>\r\n" + "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n" + "table {text-align: center;}\r\n" + "div {text-align: center;}\r\n"
				+ "body{background-color:#ADD8E6}\r\n" + "</style>\r\n" + "</head><body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Admin user = new Admin();

		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		try {
			Admin.registerAdmin(user);
			response.sendRedirect("/logout");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
