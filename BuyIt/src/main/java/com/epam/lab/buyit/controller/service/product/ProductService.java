package com.epam.lab.buyit.controller.service.product;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Product;

public interface ProductService extends GenericService<Product> {

	Product updateByProductId(Product item);

	int getCountBySubCategoryId(int id);

	List<Product> getLatestProducts(int number);

}
