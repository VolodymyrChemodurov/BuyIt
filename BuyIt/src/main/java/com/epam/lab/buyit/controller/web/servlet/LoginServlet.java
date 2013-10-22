package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.Status;
import com.epam.lab.buyit.model.User;

public class LoginServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LoginServlet.class);
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userService = new UserServiceImpl();
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		User user = userService.getUser(login, password);

		if (user != null) {
			LOGGER.info(user.getLogin() + " sign in");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			if (user.getBan().equals(Status.BANNED.getStatus())) {
				request.setAttribute("message",
						"Sorry, you are banned. Write email to administrator for more information");
				request.setAttribute("alert", "error");
				request.getRequestDispatcher("message_page").forward(request, response);
			} else
				response.sendRedirect("homePageServlet");
		}

	}

}
