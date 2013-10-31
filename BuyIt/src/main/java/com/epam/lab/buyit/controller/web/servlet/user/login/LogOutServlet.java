package com.epam.lab.buyit.controller.web.servlet.user.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.User;

public class LogOutServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LogOutServlet.class);
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			LOGGER.info(((User)session.getAttribute("user")).getLogin() + " logout");
			session.removeAttribute("user");
		}
		response.sendRedirect("homePageServlet");
	}

}
