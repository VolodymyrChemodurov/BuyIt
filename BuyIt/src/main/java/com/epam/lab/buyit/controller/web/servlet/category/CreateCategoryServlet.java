package com.epam.lab.buyit.controller.web.servlet.category;

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
			flag = createNewCategory(request, flag);

		}
		if ((request.getParameter("selectedCategory") != null)
				&& (!(request.getParameter("selectedCategory")
						.equals("Select...")))) {
			int selectedCtgr = Integer.parseInt(request
					.getParameter("selectedCategory"));
			if ((request.getParameter("subCategoryCreate") != null)
					&& (request.getParameter("subCategoryCreate").length() > 0)) {
				createNewSubCategory(request, flag, selectedCtgr);
			}
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("categories", creator.getAllItems());
		request.getRequestDispatcher("categoryCreator").forward(request,
				response);
	}

	private void createNewSubCategory(HttpServletRequest request, boolean flag,
			int selectedCtgr) {
		String selectedSub = request.getParameter("subCategoryCreate");
		Category category = creator.getItemById(selectedCtgr);
		List<SubCategory> subCategoryList = creator.getAllSubItems(category.getIdCategory());
		for (SubCategory subCategory : subCategoryList) {
			if (selectedSub.equalsIgnoreCase(subCategory.getName())) {
				flag = true;
				setAttr(request, "alert1", "error", "messageHeader1", "Error",
						"message1", "This sub-category already exist");
			}
		}
		if (flag == false) {
//			Category category = creator.getItemById(selectedCtgr);
			SubCategory subCategory = new SubCategory();
			subCategory.setName(selectedSub).setCategoryId(
					category.getIdCategory());
			creator.createSubCategory(subCategory);
			category.setSubCategory(subCategory);
			creator.updateItem(category);
			setAttr(request, "alert1", "success", "messageHeader1",
					"Well Done", "message1", "Sub-category created");
		}
	}

	private boolean createNewCategory(HttpServletRequest request, boolean flag) {
		String categoryName = request.getParameter("categoryName");
		List<Category> categoryList = creator.getAllItems();
		for (Category category : categoryList) {
			if (categoryName.equalsIgnoreCase(category.getName())) {
				flag = true;
				setAttr(request, "alert", "error", "messageHeader", "Error",
						"message", "This category already exist");
			}
		}
		if (flag == false) {
			Category category = new Category();
			category.setName(request.getParameter("categoryName"));
			creator.createItem(category);
			setAttr(request, "alert", "success", "messageHeader", "Well Done",
					"message", "Category created");
		}
		return flag;
	}

	private void setAttr(HttpServletRequest request, String typeName,
			String type, String msgHeadName, String msgHead, String msgName,
			String msg) {
		request.setAttribute(typeName, type);
		request.setAttribute(msgHeadName, msgHead);
		request.setAttribute(msgName, msg);
	}
}
