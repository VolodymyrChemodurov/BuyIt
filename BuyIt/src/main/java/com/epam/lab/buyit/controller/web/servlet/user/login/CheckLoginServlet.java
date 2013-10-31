package com.epam.lab.buyit.controller.web.servlet.user.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;

public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserServiceImpl service;
	
	public void init() {
		service = new UserServiceImpl();
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String responseText = login;
		if(service.checkLogin(login)) {
			responseText = "This login allready exists";
		}
		response.setContentType("text/plain");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(responseText);
	}

}
