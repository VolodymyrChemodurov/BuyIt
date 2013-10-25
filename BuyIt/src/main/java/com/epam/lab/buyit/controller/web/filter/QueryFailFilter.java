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

public class QueryFailFilter implements Filter {

	public void destroy() {
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		if(httpRequest.getAttribute("queryFail") != null) {
			httpRequest.setAttribute("message", httpRequest.getAttribute("queryFail"));
			httpRequest.setAttribute("alert", "error");
			request.setAttribute("messageHeader", "Error!");
			httpRequest.getRequestDispatcher("message_page").forward(httpRequest, httpResponse);
		} else chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
