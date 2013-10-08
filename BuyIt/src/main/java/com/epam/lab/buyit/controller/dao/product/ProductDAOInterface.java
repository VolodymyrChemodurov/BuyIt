package com.epam.lab.buyit.controller.dao.product;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Product;

public interface ProductDAOInterface extends GenericDAO<Product> {

	List<Product> getAllProducts();

}
