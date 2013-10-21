package com.epam.lab.buyit.controller.service.subcategory;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.SubCategory;

public interface SubCategoryService extends GenericService<SubCategory> {

	List<SubCategory> getAllItemsByCategoryId(int id_category);
	
	SubCategory getWithProductSelection(int subCategoryId, int offset, int numberOfRecords);

	List<SubCategory> getNotClosedByCategoryId(int id_category,int productNumber);
}
