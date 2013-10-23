package com.epam.lab.buyit.controller.dao.subcategory;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.SubCategory;

public interface SubCategoryDAOInterface extends GenericDAO<SubCategory> {

	List<SubCategory> getAllSubCategoriesByIdCategory(int id_category);
	List<SubCategory> getAllSubCategories();

}
