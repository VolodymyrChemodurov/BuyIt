package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

public class ChangeAvatarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserServiceImpl userService = new UserServiceImpl();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole() == true) {
			response.sendRedirect("adminProfile");
		} else {
			response.sendRedirect("userProfile");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("user");
		if (user.getRole() == true) {
			response.sendRedirect("adminProfile");
		} else {
			response.sendRedirect("userProfile");
		}
	}
}
