package com.epam.lab.buyit.controller.service.category;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Category;

public interface CategoryService extends GenericService<Category> {
	Category getBySubCategoryId(int subCategoryId);
	Category getNotClosedById(int id, int productNumber);
}
