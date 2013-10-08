package com.epam.lab.buyit.controller.service.category;

import java.util.List;

import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.model.Category;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;
	private SubCategoryDAO subCategoryDAO;

	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAO();
		subCategoryDAO = new SubCategoryDAO();
	}

	@Override
	public Category getItemById(int id) {
		Category category = categoryDAO.getElementById(id);
		return category;
	}

	@Override
	public List<Category> getAllItems() {
		List<Category> categories = categoryDAO.getAllCategories();
		for (Category category : categories) {
			category.setListSubCategories(subCategoryDAO
					.getAllSubCategoriesByIdCategory(category.getIdCategory()));
		}
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
