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

import org.apache.log4j.Logger;

public class LeaveMessageFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(LeaveMessageFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String messageText = request.getParameter("message");
		
		if(messageText != null && !(messageText.equals(""))) {
			LOGGER.warn("Empty message body");
			chain.doFilter(request, response);
		} else {
			httpRequest.setAttribute("message", "Sorry, you must write something.");
			httpRequest.setAttribute("alert", "block");
			request.setAttribute("messageHeader", "Mistake");
			httpRequest.getRequestDispatcher("message_page").forward(httpRequest, httpResponse);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
