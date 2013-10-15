package com.epam.lab.buyit.controller.service.product;

import java.util.List;

import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.description.DescriptionServiceImpl;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	private DescriptionDAO descriptionDAO;
	private DescriptionServiceImpl descriptionServiceImpl; 
	private AuctionServiceImp auctionService;

	public ProductServiceImpl() {
		productDAO = new ProductDAO();
		descriptionDAO = new DescriptionDAO();
		descriptionServiceImpl = new DescriptionServiceImpl();
		auctionService = new AuctionServiceImp();
	}

	@Override
	public Product getItemById(int id) {
		Product currentProduct = productDAO.getElementById(id);
		int productId =currentProduct.getIdProduct();
		Auction auction = auctionService.getByProductId(productId);
		Description description = descriptionServiceImpl.getByProductId(productId);
		
		currentProduct.setDescription(description);
		currentProduct.setAuction(auction);
		return currentProduct;
	}

	@Override
	public List<Product> getAllItems() {
		List<Product> products = productDAO.getAllProducts();
		List<Description> descriptions = descriptionDAO.getAllDescriptions();
		for (Product currentProduct : products) {
			setProductDescription(currentProduct, descriptions);
		}
		return products;
	}

	@Override
	public Product createItem(Product item) {
		int generated_product_id = productDAO.createElement(item);
		item.setIdProduct(generated_product_id);

		Description description = item.getDescription();
		description.setProductId(generated_product_id);
		descriptionDAO.createElement(description);

		return item;
	}

	@Override
	public Product updateItem(Product item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product updateByProductId(Product item) {
		productDAO.updateElement(item);

		Description description = item.getDescription();
		description.setIdDescription(item.getIdProduct());
		descriptionDAO.updateElement(description);

		return item;
	}

	private void setProductDescription(Product currentProduct,
			List<Description> descriptions) {
		for (Description currentDescription : descriptions) {
			if (currentDescription.getProductId() == currentProduct
					.getIdProduct()) {
				currentProduct.setDescription(currentDescription);
				break;
			}
		}
		return;
	}

	@Override
	public int getCountBySubCategoryId(int id) {
		return productDAO.getCountBySubCategoryId(id);
	}


}
