package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.UserCreator;
import com.epam.lab.buyit.controller.email.EmailMessageBuilder;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.validator.UserValidation;
import com.epam.lab.buyit.model.User;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> inputRegistrationValues = request
				.getParameterMap();
		UserServiceImpl userService = new UserServiceImpl();
		EmailMessageBuilder emailMessageBuilder = new EmailMessageBuilder();
		if (UserValidation.checkingInput(inputRegistrationValues)) {
			if ((request.getParameter("adminRole") != null)
					&& (request.getParameter("adminRole").equalsIgnoreCase("1"))) {
				User user = new UserCreator().create(inputRegistrationValues);
				user.setRole(true);
				user.setAvatar("bootstrap/img/avatars/admin-icon.png");
				userService.createItem(user);
				request.setAttribute("message",
						"Congratulations! Registration was successful");
				request.getRequestDispatcher("adminRegistration").forward(
						request, response);
			} else {
				User user = new UserCreator().create(inputRegistrationValues);
				userService.createItem(user);
				request.setAttribute("message",
						"Congratulations! Registration was successful");
				emailMessageBuilder.sendSuccessRegistrationForm(user);
				request.getRequestDispatcher("login_form").forward(request,
						response);
			}
		} else {
			request.setAttribute("messageHeader", "Fail");
			request.setAttribute("message", "Sorry, validation fail");
			request.getRequestDispatcher("message_page").forward(request,
					response);
		}

	}

}
