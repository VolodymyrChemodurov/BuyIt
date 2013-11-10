package com.epam.lab.buyit.controller.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class IdFilter implements Filter {
	private static final Logger LOGGER = Logger.getLogger(IdFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String id = httpRequest.getParameter("id");
		int idValue = 0;

		try {
			if (id != null)
				idValue = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			LOGGER.error(e);
		} finally {
			if (idValue > 0) {
				chain.doFilter(request, response);
			} else {
				sendToMessagePage(request, response);
			}
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	private void sendToMessagePage(ServletRequest request,
			ServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Incorrect parameters");
		request.setAttribute("messageHeader", "Warning");
		request.setAttribute("alert", "block");
		request.getRequestDispatcher("message_page").forward(request, response);
	}
}
