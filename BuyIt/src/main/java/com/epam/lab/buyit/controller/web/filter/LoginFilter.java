package com.epam.lab.buyit.controller.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.model.User;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		User user = (User) httpRequest.getSession(false).getAttribute("user");
		if (user == null) {
			httpRequest.setAttribute("message", "You must login first");
			createReturnLink(httpRequest);
			httpRequest.getRequestDispatcher("login_form").forward(httpRequest, httpResponse);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	private void createReturnLink(HttpServletRequest request) {
		StringBuffer link = request.getRequestURL();
		if(request.getQueryString() != null) {
			link.append("?").append(request.getQueryString());
		}
		request.setAttribute("returnTo", link);
		//	Map<String, String[]> parameters = request.getParameterMap();
		
	}
}
