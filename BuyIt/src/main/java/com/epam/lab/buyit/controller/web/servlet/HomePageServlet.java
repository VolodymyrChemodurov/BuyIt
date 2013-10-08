package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.web.Mook;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;

public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> cauroselImagesList = Mook.getImagesUrl();
		HttpSession session = request.getSession(true);
		session.setAttribute("categories", getcategories());
		session.setAttribute("carouselImages", cauroselImagesList);
		response.sendRedirect("homePage");	
			
	}
	
	private List<Category> getcategories() {
		List<Category> categories = new ArrayList<Category>();
		for(int i = 0; i < 5; i++) {
			Category category = new Category();
			List<SubCategory> listSubCategories = new ArrayList<SubCategory>();
			for(int j = 0; j < 3; j++) {
				SubCategory subCategory = new SubCategory();
				subCategory.setName("Apple");
				for(int k = 0; k < 4; k++) {
					Product product = new Product();
					//Description desc = new Description();
					
					product.setName("IPhone");
					subCategory.addProduct(product);
				}
				listSubCategories.add(subCategory);
			}
			category.setName("Phones").setListSubCategories(listSubCategories);
			categories.add(category);
		}
		return categories;
	}

}
