package com.epam.lab.buyit.controller.web.servlet.user.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.security.MD5Encryptor;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.utils.validator.UserValidation;
import com.epam.lab.buyit.model.User;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user.getRole() == true) {
			response.sendRedirect("adminProfile");
		} else {
			response.sendRedirect("userProfile");
		}
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = (String) request.getParameter("newPassword");
		String confirmPassword = (String) request
				.getParameter("confirmPassword");
		User user = (User) session.getAttribute("user");
		if (user.getRole() == true) {
			if (UserValidation.checkingPassword(newPassword, confirmPassword)) {
				userService.updateItem(user.setPassword(MD5Encryptor
						.encrypt(newPassword)));
				session.setAttribute("user", user);
			}
			response.sendRedirect("adminProfile");
		} else {
			if (UserValidation.checkingPassword(newPassword, confirmPassword)) {
				userService.updateItem(user.setPassword(MD5Encryptor
						.encrypt(newPassword)));
				session.setAttribute("user", user);
				request.setAttribute("passwordSuccess", "Password changed");
			} else {
				request.setAttribute("passwordFailed", "Incorrect new password");
			}
			request.getRequestDispatcher("userProfile").forward(request,
					response);
		}

	}

}
