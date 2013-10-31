package com.epam.lab.buyit.controller.web.servlet.general;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmailUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String subject = request.getParameter("subject");
		String message = request.getParameter("message");

		response.sendRedirect("mailto:buyitinternetauction@gmail.com"
				+ "?subject=" + subject + "&body=" + message);
	}
}
