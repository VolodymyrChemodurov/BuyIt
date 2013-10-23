package com.epam.lab.buyit.controller.service.creator;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.SubCategory;

public interface CreatorService extends GenericService<Category> {
	
	SubCategory createSubCategory(SubCategory item);
	List<SubCategory> getAllSubItems();

}
