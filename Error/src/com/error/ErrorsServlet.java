package com.error;

import java.util.*;


import java.io.IOException;
import javax.sql.DataSource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * Servlet implementation class ErrorsServlet
 */
@WebServlet("/errors")
public class ErrorsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void init() {	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
			
		try {
			SQLQueryGenerator queryGenerator = new SQLQueryGenerator(request);
			List<Error> errors = ErrorDAO.INSTANCE.getErrorList(queryGenerator.generateQuery());
			System.out.println("Number of Error items: " + errors.size());
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("errors.jsp").forward(request, response);
			
		}
		catch(SQLException e) {
			throw new ServletException("Cannot Obtain errors from Errors", e);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
