package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.web.Mook;

/**
 * Servlet implementation class Login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login").trim();
		String password = request.getParameter("password").trim();
		boolean loginFlag = true;
		loginFlag = Mook.authentication(login, password);
		
		if(loginFlag){
//			Account temp = user.getAccount();
//			request.getSession().setAttribute("currentUser", temp);
			response.sendRedirect("homePageServlet");
			
			
			
//			if (temp.getRole().equals("user")){
//				request.getSession().setAttribute("cards", card.getCardListByClientId(temp.getClient().getId()));
//				request.getSession().setAttribute("client", client.getClientById(temp.getClient().getId()));
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("userMain");
//				dispatcher.forward(request, response);
//				
//			} else if(temp.getRole().equals("admin")){
//				request.getSession().setAttribute("users", user.getAll());
//				RequestDispatcher dispatcher = request
//						.getRequestDispatcher("adminMain");
//				dispatcher.forward(request, response);
//			}
		} else {
			
		}
	}

}
