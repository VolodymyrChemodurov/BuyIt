package com.epam.lab.buyit.controller.dao.category;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Category;

public interface CategoryDAOInterface extends GenericDAO<Category> {

	List<Category> getAllCategories();

}
