package com.amdocs;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class employeeServelet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Register Employee;

    public void init() {
    	Employee = new Register();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("Registration.jsp").forward(request, response);
	}


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	
    	int registerEmployeeId = 0;
    	
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");

        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setUsername(username);
        employee.setPassword(password);
        employee.setContact(contact);
        employee.setAddress(address);

        try {
        	registerEmployeeId = Employee.registerUser(employee);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(registerEmployeeId > 0) {
        request.setAttribute("firstName",employee.getFirstName());
          request.setAttribute("lastName",employee.getLastName());
          request.setAttribute("username",employee.getUsername());
          request.setAttribute("contact", employee.getContact());
          request.setAttribute("address", employee.getAddress());

          RequestDispatcher requestDispatcher = request.getRequestDispatcher("employeedetails.jsp");
          requestDispatcher.forward(request, response);
        }
    }
}