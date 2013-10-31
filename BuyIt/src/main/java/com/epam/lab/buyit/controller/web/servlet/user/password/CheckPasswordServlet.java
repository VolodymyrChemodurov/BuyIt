package com.epam.lab.buyit.controller.web.servlet.user.password;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;

public class CheckPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl service;
	
	public void init() {
		service = new UserServiceImpl();
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String responseText = "Old pass incorrect";
		if(service.checkPassword(login, password)) {
			responseText = login;
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseText);
	}

}
