package com.epam.lab.buyit.controller.service.subcategory;

import java.util.List;

import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryServiceImpl implements SubCategoryService {

	private SubCategoryDAO subCategoryDAO;

	public SubCategoryServiceImpl() {
		subCategoryDAO = new SubCategoryDAO();
	}

	@Override
	public SubCategory getItemById(int id) {
		SubCategory subCategory = subCategoryDAO.getElementById(id);
		return subCategory;
	}

	@Override
	public List<SubCategory> getAllItems() {
		throw new UnsupportedOperationException();
	}

	@Override
	public SubCategory createItem(SubCategory item) {
		int generated_subcategory_id = subCategoryDAO.createElement(item);
		item.setIdSubCategory(generated_subcategory_id);
		return item;
	}

	@Override
	public SubCategory updateItem(SubCategory item) {
		subCategoryDAO.updateElement(item);
		return item;
	}

	@Override
	public List<SubCategory> getAllItemsByCategoryId(int id_category) {
		List<SubCategory> subCategories = subCategoryDAO
				.getAllSubCategoriesByIdCategory(id_category);
		return subCategories;
	}

}
