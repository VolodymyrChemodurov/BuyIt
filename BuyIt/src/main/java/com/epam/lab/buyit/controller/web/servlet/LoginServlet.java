package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userServise = new UserServiceImpl();
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		User user = userServise.getUser(login, password);
		
		if(user != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			if (user.getRole()){
				
			} else {

			}
		}
			response.sendRedirect("homePageServlet");
			
	}

}
