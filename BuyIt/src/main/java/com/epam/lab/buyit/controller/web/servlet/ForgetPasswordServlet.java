package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.email.EmailMessageBuilder;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

public class ForgetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(ForgetPasswordServlet.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");

		UserServiceImpl userService = new UserServiceImpl();
		User user = userService.getUserByLogin(login);

		if (user != null) {
			EmailMessageBuilder emailMessageBuilder = new EmailMessageBuilder();
			String name = user.getFirstName() + " " + user.getLastName();
			String newPassword = Integer.toString(new Random(System
					.currentTimeMillis()).nextInt(999999 - 100000) + 100000);
			String email = user.getContact().getEmail();
			if (userService.changePasswordByUserId(user.getIdUser(), newPassword)) {
				emailMessageBuilder.sendPasswordRecoveryForm(name, newPassword, email);
				request.setAttribute("message", "Your password change, please check your e-mail");
				request.setAttribute("messageHeader", "Success");
				request.setAttribute("alert", "success");
				request.getRequestDispatcher("message_page").forward(request, response);
			} else {
				LOGGER.warn("BAG");
			}
		}
	}
}
