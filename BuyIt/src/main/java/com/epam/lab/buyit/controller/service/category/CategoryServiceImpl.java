package com.epam.lab.buyit.controller.service.category;

import java.util.List;

import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.SubCategory;

public class CategoryServiceImpl implements CategoryService {
	private CategoryDAO categoryDAO;
	private SubCategoryServiceImpl subCategoryService;

	public CategoryServiceImpl() {
		categoryDAO = new CategoryDAO();
		subCategoryService = new SubCategoryServiceImpl();
	}

	@Override
	public Category getItemById(int id) {
		Category category = categoryDAO.getElementById(id);
		category.setListSubCategories(subCategoryService
				.getAllItemsByCategoryId(id));
		return category;
	}

	@Override
	public List<Category> getAllItems() {
		List<Category> categories = categoryDAO.getAllCategories();
		for (Category category : categories) {
			category.setListSubCategories(subCategoryService
					.getAllItemsByCategoryId(category.getIdCategory()));
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

	@Override
	public Category getBySubCategoryId(int subCategoryId) {
		Category category;
		SubCategory subCategory;
		subCategory = subCategoryService.getItemById(subCategoryId);
		category = categoryDAO.getElementById(subCategory.getCategoryId());
		category.getListSubCategories().add(subCategory);

		return category;
	}

	@Override
	public Category getNotClosedById(int id, int productNumber) {
		Category category = categoryDAO.getElementById(id);
		if(category != null) {
			category.setListSubCategories(subCategoryService.getNotClosedByCategoryId(id, productNumber));
		}
		return category;
	}

}
