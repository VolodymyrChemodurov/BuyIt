package com.epam.lab.buyit.controller.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.model.Status;
import com.epam.lab.buyit.model.User;

public class BanFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		User user = (User) httpRequest.getSession(false).getAttribute("user");
		if (user.getBan().equals(Status.BANNED.getStatus())) {
			httpRequest	.setAttribute("message",
							"Sorry, you are banned. Write email to administrator for more information");
			httpRequest.setAttribute("alert", "error");
			httpRequest.setAttribute("messageHeader", "Banned!");
			httpRequest.getRequestDispatcher("message_page").forward(
					httpRequest, httpResponse);
		} else
			chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
