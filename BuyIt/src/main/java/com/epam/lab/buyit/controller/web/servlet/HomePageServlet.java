package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.web.Mook;

/**
 * Servlet implementation class homePageServlet
 */

public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,List<String>> productList = Mook.getProducts();
		List<String> cauroselImagesList = Mook.getImagesUrl();
		HttpSession session = request.getSession(true);
		session.setAttribute("products", productList);
		session.setAttribute("carouselImages", cauroselImagesList);
		response.sendRedirect("homePage");	
		
		
	}

}
