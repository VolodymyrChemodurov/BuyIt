package com.epam.lab.buyit.controller.service.subcategory;

import java.util.List;

import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.description.DescriptionServiceImpl;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;

public class SubCategoryServiceImpl implements SubCategoryService {
	private SubCategoryDAO subCategoryDAO;
	private ProductServiceImpl productService;
	private AuctionServiceImp auctionService;
	private DescriptionServiceImpl descriptionService;

	public SubCategoryServiceImpl() {
		subCategoryDAO = new SubCategoryDAO();
		productService = new ProductServiceImpl();
		auctionService = new AuctionServiceImp();
		descriptionService = new DescriptionServiceImpl();
		productService = new ProductServiceImpl();
	}

	@Override
	public SubCategory getItemById(int id) {
		SubCategory subCategory = subCategoryDAO.getElementById(id);
		List<Product> products = productService.getBySubCategoryId(subCategory
				.getIdSubCategory());
		for (Product product : products) {
			product.setAuction(auctionService.getByProductId(product
					.getIdProduct()));
			product.setDescription(descriptionService.getByProductId(product
					.getIdProduct()));
		}
		subCategory.setProducts(products);
		return subCategory;
	}

	@Override
	public List<SubCategory> getAllItems() {
		List<SubCategory> subCategories = subCategoryDAO.getAllSubCategories();
		return subCategories;
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
		for (SubCategory subCategory : subCategories) {
			subCategory.setProducts(productService
					.getBySubCategoryId(subCategory.getIdSubCategory()));
		}
		return subCategories;
	}

	@Override
	public SubCategory getWithProductSelection(int subCategoryId, int offset,
			int numberOfRecords) {

		SubCategory subCategory = subCategoryDAO.getElementById(subCategoryId);
		List<Product> products = productService.getSelectionBySubCategoryId(
				subCategoryId, offset, numberOfRecords);
		for (Product product : products) {
			product.setAuction(auctionService.getByProductId(product
					.getIdProduct()));
			product.setDescription(descriptionService.getByProductId(product
					.getIdProduct()));
		}
		subCategory.setProducts(products);
		return subCategory;
	}

	@Override
	public List<SubCategory> getNotClosedByCategoryId(int id_category,
			int productNumber) {
		List<SubCategory> subCategories = subCategoryDAO
				.getAllSubCategoriesByIdCategory(id_category);
		for (SubCategory subCategory : subCategories) {
			subCategory.setProducts(productService.getNotClosedBySubCategoryId(
					subCategory.getIdSubCategory(), productNumber));
		}
		return subCategories;
	}

}
