package com.epam.lab.buyit.controller.web.servlet;

import static com.epam.lab.buyit.controller.utils.ParseRequest.parseRequest;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.web.client.ImageClientWebService;
import com.epam.lab.buyit.model.User;

public class ChangeAvatarServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(ChangeAvatarServlet.class);
	private static final long serialVersionUID = 1L;
	private UserServiceImpl userService;

	public void init() {
		userService = new UserServiceImpl();
	}

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
		ImageClientWebService imageClientWebService = new ImageClientWebService();

		User user = (User) request.getSession().getAttribute("user");
		LOGGER.info("start update avatar");
		String token = imageClientWebService.createToken(999);
		List<FileItem> images = parseRequest(request);
		List<String> urls = imageClientWebService.createImages(images, token);

		if (urls.size() == 1) {
			user.setAvatar(urls.get(0));
			userService.updateItem(user);
			LOGGER.info("update successful");
		}
		if (user.getRole() == true) {
			response.sendRedirect("adminProfile");
		} else {
			response.sendRedirect("userProfile");
		}
	}
}
