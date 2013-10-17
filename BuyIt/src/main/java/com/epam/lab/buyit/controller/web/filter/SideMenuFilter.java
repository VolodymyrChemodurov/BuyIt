package com.epam.lab.buyit.controller.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.service.category.CategoryServiceImpl;

public class SideMenuFilter implements Filter {
	private CategoryServiceImpl categoryService;
	
	public void init(FilterConfig fConfig) throws ServletException {
		categoryService = new CategoryServiceImpl();
	}
	
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		if(session == null) {
			HttpSession newSession = httpRequest.getSession(true);
			newSession.setAttribute("categories", categoryService.getAllItems());
		}
		
		chain.doFilter(request, response);
	}

	

}
