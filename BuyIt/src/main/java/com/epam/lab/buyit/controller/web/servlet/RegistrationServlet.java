package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.creator.UserCreator;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.controller.validator.Validator;
import com.epam.lab.buyit.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		Map<String, String[]> inputRegistrationValues = request.getParameterMap();
		UserServiceImpl userService = new UserServiceImpl();
		if (checkingInput(inputRegistrationValues)) {
			User user = new UserCreator().create(inputRegistrationValues);
			userService.createItem(user);
			response.sendRedirect("homePageServlet");
		} else {
			// TODO change
			response.sendRedirect("error404");
		}

	}

	private boolean checkingInput(Map<String, String[]> inputMap) {
		boolean result = true;
		for (Validator currentElement : Validator.values()) {
			String name = currentElement.getField();
			if (name.equals(Validator.HOUSE.getField())) {
				StringBuilder builder = new StringBuilder();
				String[] tempInputArray = inputMap.get(name);
				builder.append(tempInputArray[0]).append("/").append(tempInputArray[1]);
				result = currentElement.validate(builder.toString());
			} else {
				result = currentElement.validate(inputMap.get(name)[0]);
			}
			if (!result) {
				break;
			}
		}
		result = result
				&& inputMap.get(Validator.PASSWORD.getField())[0].equals(
						inputMap.get(Validator.CONFIRM_PASSWORD.getField())[0]);
		return result;
	}

}
