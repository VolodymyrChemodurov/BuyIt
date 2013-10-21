package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.security.MD5Encryptor;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.validator.UserValidation;
import com.epam.lab.buyit.model.User;

public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String newPassword = (String) request.getParameter("newPassword");
		String confirmPassword = (String) request.getParameter("confirmPassword");
		User user = (User) session.getAttribute("user");
		if(UserValidation.checkingPassword(newPassword, confirmPassword)){
			userService.updateItem(user.setPassword(MD5Encryptor.encrypt(newPassword)));
			session.setAttribute("user", user);
		}
		response.sendRedirect("userProfile");
	
	}

}
