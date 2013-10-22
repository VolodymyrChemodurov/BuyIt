package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.model.Contact;
import com.epam.lab.buyit.model.Message;
import com.epam.lab.buyit.model.User;

public class UserWallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<User, Message> comments = new LinkedHashMap<User, Message>();
		
		for(int i = 0; i < 59; i++) {
			Message message = new Message();
			message.setFromUserId(i+1).setMessage("TEsst messsage to user " + i );
			User user = new User();
			user.setLogin("user" + i).setIdUser(i);
			comments.put(user, message);
		}
		User user = new User();
		user.setFirstName("Volodymyr").setLastName("Chemodurov");
		user.setContact(new Contact().setEmail("fdsjkas@gmail.com"));
		request.setAttribute("user", user.setAvatar("bootstrap/img/avatars/user-icon.png"));
		request.setAttribute("messages", comments);
		request.getRequestDispatcher("user_wall.jsp").forward(request, response);
	}

}
