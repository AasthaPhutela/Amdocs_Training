package com.amdocs.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.main.Feedback;

public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FeedbackServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("insertFeedback.jsp").forward(request, response);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head>\r\n"
				+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n"
				+ "<title>View Feedback</title>\r\n" + "<style>\r\n" + "h1 {text-align: center;}\r\n"
				+ "p {text-align: center;}\r\n" + "table {text-align: center;}\r\n" + "div {text-align: center;}\r\n"
				+ "body{background-color:#ADD8E6}\r\n" + "</style>\r\n" + "</head><body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie ck[]=request.getCookies();
		Feedback feedback;
		try {
			feedback = new Feedback(Integer.parseInt(ck[0].getValue()),request.getParameter("feedback_message"));
			request.setAttribute("message1","Your Feedback is Submitted ");
			request.setAttribute("message2","Feedback Id :" + feedback.getFeedback_id());
			request.getRequestDispatcher("resultFeedback.jsp").forward(request, response);
		} 
		catch (NumberFormatException | SQLException e) {
			request.setAttribute("message1",e.getMessage());
			request.getRequestDispatcher("resultFeedback.jsp").forward(request, response);
			e.printStackTrace();
		}
	}
	}

