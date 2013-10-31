package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.rating.RatingService;
import com.epam.lab.buyit.controller.service.rating.RatingServiceImpl;
import com.epam.lab.buyit.controller.service.user.UserService;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.web.client.MessageClientWebService;
import com.epam.lab.buyit.model.Message;
import com.epam.lab.buyit.model.User;

public class UserWallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private RatingService ratingService;
	private MessageClientWebService messageService;

	public void init() {
		userService = new UserServiceImpl();
		ratingService = new RatingServiceImpl();
		messageService = new MessageClientWebService();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Map<User, Message> comments = new LinkedHashMap<User, Message>();
		int userId = Integer.parseInt(request.getParameter("id"));
		List<Message> messages = messageService.getMessagesByUserId(userId);
		for (Message currentMessage : messages) {
			comments.put(
					userService.getItemById(currentMessage.getFromUserId()),
					currentMessage);
		}

		request.setAttribute("userRating", ratingService.getUserRating(userId));
		request.setAttribute("userInfo", userService.getItemById(userId));
		request.setAttribute("messages", comments);
		request.getRequestDispatcher("user_wall.jsp")
				.forward(request, response);
	}

}
