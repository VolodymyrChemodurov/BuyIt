package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.web.client.MessageClientWebService;
import com.epam.lab.buyit.model.Message;
import com.sun.jersey.api.client.ClientHandlerException;

public class LeaveMessageServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(LeaveMessageServlet.class);
	private static final long serialVersionUID = 1L;
	private MessageClientWebService messageService;

	public void init() {
		messageService = new MessageClientWebService();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fromId = Integer.parseInt(request.getParameter("fromId"));
		int toId = Integer.parseInt(request.getParameter("toId"));
		String messageText = request.getParameter("message");

		Message message = new Message();
		message.setFromUserId(fromId).setToUserId(toId).setMessage(messageText);
		try {
			boolean result = messageService.createMessage(message);
			LOGGER.info("Creating new message: " + message + ". Result: " + (result ? " Ok" : " Fail"));
			if (!result) {
				request.setAttribute("message", "Sorry, some mistake on message service.");
				request.setAttribute("messageHeader", "Warning");
				request.setAttribute("alert", "block");
				request.getRequestDispatcher("message_page").forward(request, response);
			}
			response.sendRedirect("user_wall?id=" + request.getParameter("toId"));
		} catch (ClientHandlerException e) {
			LOGGER.error(e);
			request.setAttribute("message", "Sorry, message service is not available.");
			request.setAttribute("messageHeader", "Warning");
			request.setAttribute("alert", "block");
			request.getRequestDispatcher("message_page").forward(request, response);
		}
	}

}
