package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

@WebServlet("/TestUserServiceServlet")
public class TestUserServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl service = new UserServiceImpl();
		User user = new User();
		user.setFirstName("Boby").setLastName("Begins").setLogin("log").setPassword("papa");
		user.getContact().setEmail("mysia@gmail.com");
		service.createItem(user);
	}

}
