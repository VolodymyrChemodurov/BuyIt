package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.UserCreator;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

/**
 * Servlet implementation class UserPageServlet
 */
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userService = new UserServiceImpl();
		Map<String, String[]> inputRegistrationValues = request.getParameterMap();
		User user = new UserCreator().create(inputRegistrationValues);
		request.getSession().setAttribute("user", userService.updateItem(user));
		response.sendRedirect("userProfile");
		
	}

}
