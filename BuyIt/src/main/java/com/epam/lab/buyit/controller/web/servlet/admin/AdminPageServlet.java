package com.epam.lab.buyit.controller.web.servlet.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.admin.AdminService;
import com.epam.lab.buyit.controller.service.admin.AdminServiceImpl;
import com.epam.lab.buyit.controller.service.user.UserServiceImpl;
import com.epam.lab.buyit.model.User;

public class AdminPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService = null;
	private UserServiceImpl userService = null;

	public AdminPageServlet() {
		super();
		adminService = new AdminServiceImpl();
		userService = new UserServiceImpl();
	}

	public void init(ServletConfig config) throws ServletException {
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if (request.getParameter("idUsr") != null
				&& request.getParameter("button") != null) {

			String ids = request.getParameter("idUsr");
			String status = request.getParameter("button");

			if (status.equals("bann")) {
				userService.setBann(ids);
			} else {
				userService.setUnbann(ids);
			}

			List<User> onlyUsers = new ArrayList<>();
			onlyUsers = adminService.getAllItems();
			request.getSession().setAttribute("onlyUsers", onlyUsers);
			response.sendRedirect("adminMainPage");

		} else {

			List<User> onlyUsers = new ArrayList<>();
			onlyUsers = adminService.getAllItems();
			request.getSession().setAttribute("onlyUsers", onlyUsers);
			response.sendRedirect("adminMainPage");

		}

	}

}
