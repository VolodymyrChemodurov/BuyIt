package com.epam.lab.buyit.controller.service.category;

import java.util.List;

import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.model.Category;

public class CategoryServiceImpl implements CategoryService {

	private CategoryDAO categoryDAO;

	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAO();
	}

	@Override
	public Category getItemById(int id) {
		Category category = categoryDAO.getElementById(id);
		return category;
	}

	@Override
	public List<Category> getAllItems() {
		List<Category> categories = categoryDAO.getAllCategories();
		return categories;
	}

	@Override
	public Category createItem(Category item) {
		int generated_category_id = categoryDAO.createElement(item);
		item.setIdCategory(generated_category_id);
		return item;
	}

	@Override
	public Category updateItem(Category item) {
		categoryDAO.updateElement(item);
		return item;
	}

}
