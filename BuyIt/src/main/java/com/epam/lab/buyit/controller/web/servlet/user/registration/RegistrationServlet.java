package com.epam.lab.buyit.controller.web.servlet.user.registration;

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
	private UserServiceImpl userService;
	private EmailMessageBuilder emailMessageBuilder;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<String, String[]> inputRegistrationValues = request
				.getParameterMap();
		userService = new UserServiceImpl();
		
		if (UserValidation.checkingInput(inputRegistrationValues)) {
			if ((request.getParameter("adminRole") != null)
					&& (request.getParameter("adminRole").equalsIgnoreCase("1"))) {
				createUser(inputRegistrationValues, request, true);
				request.getRequestDispatcher("adminRegistration").forward(
						request, response);
			} else {
				createUser(inputRegistrationValues, request, false);
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

	private void createUser(Map<String, String[]> inputRegistrationValues, HttpServletRequest request, boolean role ){
		User user = new UserCreator().create(inputRegistrationValues);
		user.setRole(role);
		userService.createItem(user);
		request.setAttribute("message",
				"Congratulations! Registration was successful");
		request.setAttribute("messageColor", "green");
		emailMessageBuilder = new EmailMessageBuilder();
		emailMessageBuilder.sendSuccessRegistrationForm(user);
	}
	
}
