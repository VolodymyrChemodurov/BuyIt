package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.setters.UserSetter;
import com.epam.lab.buyit.controller.validator.UserValidation;
import com.epam.lab.buyit.model.User;

public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserServiceImpl userService = new UserServiceImpl();
		Map<String, String[]> inputValues = request.getParameterMap();
		User user = (User) request.getSession().getAttribute("user");
		if (UserValidation.checkingInputValues(inputValues)) {
			setUserInfo(user, inputValues);
			if (user.getRole()) {
				redirect(request, response, userService, user, "user",
						"adminProfile");
			} else {
				redirect(request, response, userService, user, "user",
						"userProfile");
			}
		}

	}

	private void setUserInfo(User user, Map<String, String[]> inputValues) {

		for (String key : inputValues.keySet()) {
			UserSetter setter = UserSetter.getSetter(key);
			String value = inputValues.get(key)[0];
			setter.setField(user, value);
		}

	}

	private void redirect(HttpServletRequest request,
			HttpServletResponse response, UserServiceImpl userService,
			User user, String attrName, String jsp) throws IOException {
		request.getSession().setAttribute(attrName,
				userService.updateItem(user));
		response.sendRedirect(jsp);
	}

}
