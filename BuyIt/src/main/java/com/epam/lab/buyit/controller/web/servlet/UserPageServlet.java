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

/**
 * Servlet implementation class UserPageServlet
 */
public class UserPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		UserServiceImpl userService = new UserServiceImpl();
		Map<String, String[]> inputValues = request.getParameterMap();
		User user = (User) request.getSession().getAttribute("user");
		if (UserValidation.checkingInputValues(inputValues)){
			setUserInfo (user, inputValues);
			request.getSession().setAttribute("user", userService.updateItem(user));
		}
		response.sendRedirect("userProfile");
	}

	private void setUserInfo(User user, Map<String, String[]> inputValues) {

		for (String key : inputValues.keySet()) {
			UserSetter setter = UserSetter.getSetter(key);
			String value = inputValues.get(key)[0];
			setter.setField(user, value);
		}

	}

}
