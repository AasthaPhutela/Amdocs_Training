package com.amdocs.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.Course;

public class AddCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public AddCourseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addCourse.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>View Feedback</title>\r\n" + "<style>\r\n" + "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n" + "table {text-align: center;}\r\n" + "div {text-align: center;}\r\n"
				+ "body{background-color:#ADD8E6}\r\n" + "</style>\r\n" + "</head><body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String desp = request.getParameter("desp");
        String fees = request.getParameter("fees");
        String resource = request.getParameter("resource");
            
        try {
        	Course c = new Course(name,resource,desp,fees);
			c.addCourse();
			response.sendRedirect("/FinalProject/admin");
		} catch (SQLException e) {
			e.printStackTrace();
			response.sendRedirect("/FinalProject/admin/course");
		}
	}

}