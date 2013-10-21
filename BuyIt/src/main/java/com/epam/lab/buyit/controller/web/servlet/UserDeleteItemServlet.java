package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;

/**
 * Servlet implementation class SubCategoryServlet
 */
public class UserDeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		SubCategoryServiceImpl subService = new SubCategoryServiceImpl();
//		String id_string = request.getParameter("categoryId");
//		int id = Integer.parseInt(id_string);
//		List<SubCategory> subList = subService.getAllItemsByCategoryId(id); 
//		String data = new Gson().toJson(subList);
//		response.setContentType("application/json"); 
//		response.setCharacterEncoding("UTF-8");
//		response.getWriter().write(data);
		System.out.println("in delete servlet");
		
		String id = request.getParameter("itemId");
		ProductServiceImpl productService = new ProductServiceImpl();
		productService.deleteItemById(Integer.parseInt(id));
		request.getSession().setAttribute("userActiveSales", productService.getAllItems());
		request.getSession().setAttribute("oleg", "Petro");
	
	}

}
