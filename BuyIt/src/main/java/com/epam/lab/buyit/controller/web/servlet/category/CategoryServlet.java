package com.epam.lab.buyit.controller.web.servlet.category;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.service.category.CategoryService;
import com.epam.lab.buyit.controller.service.category.CategoryServiceImpl;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.SubCategory;

public class CategoryServlet extends HttpServlet {
	private static final Logger LOGGER = Logger.getLogger(CategoryServlet.class);
	private static final long serialVersionUID = 1L;
	private static final int ITEMS_ON_PAGE = 8;
	private CategoryService categoryService;
	private SubCategoryServiceImpl subCategoryService;
	private ProductServiceImpl productService;

	public void init() {
		categoryService = new CategoryServiceImpl();
		subCategoryService = new SubCategoryServiceImpl();
		productService = new ProductServiceImpl();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serve(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		serve(request, response);
	}

	private void serve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int subCategoryId = Integer.parseInt(request.getParameter("id"));
		int page = 1;
		if (request.getParameter("page") != null) {
			try {
				page = Integer.parseInt(request.getParameter("page"));
			} catch (NumberFormatException e) {
				LOGGER.error(e);
				page = 1;
			}
			if(page <= 0) page = 1;
		}

		SubCategory subCategory = getProductSelection(subCategoryId, page);

		if (subCategory != null) {
			if(subCategory.getProducts().size() == 0) {
				subCategory = getProductSelection(subCategoryId, 1);
				page = 1;
			}
			int numberOfRecords = productService.getCountBySubCategoryId(subCategoryId);
			int numberOfPages = (int) Math.ceil(numberOfRecords * 1.0 / ITEMS_ON_PAGE);

			request.setAttribute("categoryId", subCategory.getCategoryId());

			Category category = categoryService.getBySubCategoryId(subCategory.getIdSubCategory());

			request.setAttribute("categoryName", category.getName());
			request.setAttribute("subCategory", subCategory);
			request.setAttribute("noOfPages", numberOfPages);
			request.setAttribute("page", page);
			request.getRequestDispatcher("category").forward(request, response);
		} else {
			sendToMessagePage(request, response);
		}
	}

	private SubCategory getProductSelection(int subCategoryId, int page) {
		SubCategory subCategory = subCategoryService.getWithProductSelection(
				subCategoryId, (page - 1) * ITEMS_ON_PAGE, ITEMS_ON_PAGE);
		return subCategory;
	}
	
	private void sendToMessagePage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("message", "Sorry, this subcategory does not exist");
		request.setAttribute("messageHeader", "Warning");
		request.setAttribute("alert", "block");
		request.getRequestDispatcher("message_page").forward(request, response);
	}
}
