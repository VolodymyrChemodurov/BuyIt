package com.epam.lab.buyit.controller.service.creator;

import java.util.List;

import com.epam.lab.buyit.controller.service.category.CategoryServiceImpl;
import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.SubCategory;

public class CreatorServiceImpl implements CreatorService {

	private CategoryServiceImpl categoryService;
	private SubCategoryServiceImpl subCategoryService;

	public CreatorServiceImpl() {
		categoryService = new CategoryServiceImpl();
		subCategoryService = new SubCategoryServiceImpl();
	}

	@Override
	public SubCategory createSubCategory(SubCategory item) {
		return subCategoryService.createItem(item);
	}

	@Override
	public Category createItem(Category item) {
		return categoryService.createItem(item);
	}

	@Override
	public Category getItemById(int id) {
		return categoryService.getItemById(id);
	}

	@Override
	public List<Category> getAllItems() {
		return categoryService.getAllItems();
	}

	@Override
	public Category updateItem(Category item) {
		return categoryService.updateItem(item);
	}

	@Override
	public List<SubCategory> getAllSubItems() {
		return subCategoryService.getAllItems();
	}

}
