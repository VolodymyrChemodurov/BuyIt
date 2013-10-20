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

public class BuyItFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(BuyItFilter.class);
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if (httpRequest.getParameter("quantity") == null)
			parameterNotFound("Quantity parameter not found in request", httpRequest, httpResponse);
		else if (httpRequest.getParameter("id_product") == null)
			parameterNotFound("ProductId parameter not found in request", httpRequest, httpResponse);
		else chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private void parameterNotFound(String message, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LOGGER.error(message);
		request.setAttribute("message", "Sorry, some internal error occured.");
		request.setAttribute("alert", "error");
		request.getRequestDispatcher("message_page").forward(request, response);
	}
}
