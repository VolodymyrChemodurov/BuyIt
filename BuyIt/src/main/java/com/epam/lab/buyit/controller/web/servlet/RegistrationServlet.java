package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.UserCreator;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.validator.UserValidation;
import com.epam.lab.buyit.model.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> inputRegistrationValues = request.getParameterMap();
		UserServiceImpl userService = new UserServiceImpl();
		if (UserValidation.checkingInput(inputRegistrationValues)) {
			User user = new UserCreator().create(inputRegistrationValues);
			userService.createItem(user);
			request.setAttribute("message", "Congratulations! Registration was successful");
			request.getRequestDispatcher("login_form").forward(request, response);
		} else {
			response.sendRedirect("error404");
		}

	}

}
