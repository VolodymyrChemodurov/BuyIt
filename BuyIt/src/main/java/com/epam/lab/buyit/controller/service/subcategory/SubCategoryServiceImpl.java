package com.epam.lab.buyit.controller.service.subcategory;

import java.util.List;

import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.controller.service.description.DescriptionServiceImpl;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryServiceImpl implements SubCategoryService {
	private SubCategoryDAO subCategoryDAO;
	private ProductDAO productDAO;
	private AuctionDAO auctionDAO;
	private DescriptionServiceImpl descriptionService;

	public SubCategoryServiceImpl() {
		subCategoryDAO = new SubCategoryDAO();
		productDAO = new ProductDAO();
		auctionDAO = new AuctionDAO();
		descriptionService = new DescriptionServiceImpl();
	}

	@Override
	public SubCategory getItemById(int id) {
		SubCategory subCategory = subCategoryDAO.getElementById(id);
		List<Product> products = productDAO
				.getProductsBySubCategoryId(subCategory.getIdSubCategory());
		for (Product product : products) {
			product.setAuction(auctionDAO.getByProductId(product.getIdProduct()));
			product.setDescription(descriptionService.getByProductId(product
					.getIdProduct()));
		}
		subCategory.setProducts(products);
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
