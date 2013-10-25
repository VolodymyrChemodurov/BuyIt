package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.epam.lab.buyit.controller.service.creator.CreatorServiceImpl;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.SubCategory;

public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CreatorServiceImpl creator = null;

	@Override
	public void init() throws ServletException {
		super.init();
		creator = new CreatorServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		boolean flag = false;
		if ((request.getParameter("categoryName") != null)
				&& (request.getParameter("categoryName").length() > 0)) {
			String categoryName = request.getParameter("categoryName");
			List<Category> categoryList = creator.getAllItems();
			for (Category category : categoryList) {
				if (categoryName.equalsIgnoreCase(category.getName())) {
					flag = true;
					request.setAttribute("alert", "error");
					request.setAttribute("messageHeader", "Error");
					request.setAttribute("message",
							"This category already exist");
				}
			}
			if (flag == false) {
				Category category = new Category();
				category.setName(request.getParameter("categoryName"));
				creator.createItem(category);
				request.setAttribute("alert", "success");
				request.setAttribute("messageHeader", "Well Done");
				request.setAttribute("message", "Category created");
			}

		} else {
			if ((request.getParameter("selectedCategory") != null)
					&& (!(request.getParameter("selectedCategory")
							.equals("Select...")))) {
				int selectedCtgr = Integer.parseInt(request
						.getParameter("selectedCategory"));
				if ((request.getParameter("subCategoryCreate") != null)
						&& (request.getParameter("subCategoryCreate").length() > 0)) {
					String selectedSub = request
							.getParameter("subCategoryCreate");
					List<SubCategory> subCategoryList = creator
							.getAllSubItems();
					for (SubCategory subCategory : subCategoryList) {
						if (selectedSub.equalsIgnoreCase(subCategory.getName())) {
							flag = true;
							request.setAttribute("alert1", "error");
							request.setAttribute("messageHeader1", "Error");
							request.setAttribute("message1",
									"This sub-category already exist");
						}
					}
					if (flag == false) {
						Category category = creator.getItemById(selectedCtgr);
						SubCategory subCategory = new SubCategory();
						subCategory.setName(selectedSub).setCategoryId(
								category.getIdCategory());
						creator.createSubCategory(subCategory);
						category.setSubCategory(subCategory);
						creator.updateItem(category);
						request.setAttribute("alert1", "success");
						request.setAttribute("messageHeader1", "Well Done");
						request.setAttribute("message1", "Sub-category created");
					}
				}
			} else {
				request.setAttribute("alert1", "error");
				request.setAttribute("messageHeader1", "Error");
				request.setAttribute("message1",
						"Before create sub-category select category");
			}
		}

		HttpSession session = request.getSession(false);
		session.setAttribute("categories", creator.getAllItems());
		request.getRequestDispatcher("categoryCreator").forward(request,
				response);
	}
}
