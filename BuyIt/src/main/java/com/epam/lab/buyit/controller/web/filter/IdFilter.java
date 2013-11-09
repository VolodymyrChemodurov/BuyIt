package com.epam.lab.buyit.controller.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class IdFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		
		String id = httpRequest.getParameter("id");
		if (id == null || id.equals("")) {
			request.setAttribute("message", "Incorrect parameters");
			request.setAttribute("messageHeader", "Warning");
			request.setAttribute("alert", "block");
			request.getRequestDispatcher("message_page").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
