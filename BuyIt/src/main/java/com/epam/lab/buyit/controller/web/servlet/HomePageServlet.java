package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.service.category.CategoryServiceImpl;
import com.epam.lab.buyit.controller.service.image.ImageServiceImpl;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.utils.RegionCreator;

public class HomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryServiceImpl categoryService;
	private ProductServiceImpl productService;
	private ImageServiceImpl imageService;

	public void init() {
		categoryService = new CategoryServiceImpl();
		productService = new ProductServiceImpl();
		imageService = new ImageServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<String> cauroselImagesList = imageService.getImagesUrl();
		HttpSession session = request.getSession(true);
		session.setAttribute("categories", categoryService.getAllItems());
		session.setAttribute("carouselImages", cauroselImagesList);
		session.setAttribute("latestProducts",
				productService.getLatestProducts(8));
		session.setAttribute("region", RegionCreator.getRegionList());
		response.sendRedirect("homePage");

	}

}
