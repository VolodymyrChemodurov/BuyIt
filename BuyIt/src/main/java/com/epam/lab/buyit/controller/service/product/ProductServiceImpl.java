package com.epam.lab.buyit.controller.service.product;

import java.util.ArrayList;
import java.util.List;

//import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
//import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.service.auction.AuctionServiceImp;
import com.epam.lab.buyit.controller.service.description.DescriptionServiceImpl;
import com.epam.lab.buyit.controller.service.image.ImageServiceImpl;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDAO productDAO;
	private ImageServiceImpl imageService;
	private DescriptionServiceImpl descriptionService;
	private AuctionServiceImp auctionService;

	public ProductServiceImpl() {
		productDAO = new ProductDAO();
		imageService = new ImageServiceImpl();
		descriptionService = new DescriptionServiceImpl();
		auctionService = new AuctionServiceImp();
	}

	@Override
	public Product getItemById(int id) {
		Product currentProduct = productDAO.getElementById(id);
		int productId = currentProduct.getIdProduct();
		Auction auction = auctionService.getByProductId(productId);
		Description description = descriptionService.getByProductId(productId);

		currentProduct.setDescription(description);
		currentProduct.setAuction(auction);
		return currentProduct;
	}

	@Override
	public List<Product> getAllItems() {
		List<Product> products = productDAO.getAllProducts();
		List<Description> descriptions = descriptionService.getAllItems();
		for (Product currentProduct : products) {
			setProductDescription(currentProduct, descriptions);
		}
		return products;
	}

	public List<Product> getItemsByUserId(int id) {
		List<Product> products = productDAO.getElementsByUserId(id);
		for (Product currentProduct : products) {
			Auction auction = auctionService.getByProductId(currentProduct
					.getIdProduct());
			currentProduct.setAuction(auction);
		}

		return products;
	}

	@Override
	public Product createItem(Product item) {
		int generated_product_id = productDAO.createElement(item);
		item.setIdProduct(generated_product_id);

		Description description = item.getDescription();
		description.setProductId(generated_product_id);
		descriptionService.createItem(description);

		Auction auction = item.getAuction();
		auction.setProductId(generated_product_id);
		auctionService.createItem(auction);

		return item;
	}

	@Override
	public Product updateItem(Product item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product updateByProductId(Product item) {
		productDAO.updateElement(item);
		descriptionService.updateItem(item.getDescription());
		return item;
	}

	private void setProductDescription(Product currentProduct,
			List<Description> descriptions) {
		for (Description currentDescription : descriptions) {
			if (currentDescription.getProductId() == currentProduct
					.getIdProduct()) {
				currentDescription.setItemPhotos(imageService
						.getImagesByDescriptionId(currentDescription
								.getIdDescription()));
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

	@Override
	public List<Product> getLatestProducts(int number) {
		List<Product> latestProducts = new ArrayList<Product>();
		List<Auction> latestAuctions = auctionService.getLatestAuctions(number);
		for (Auction currAuction : latestAuctions) {
			Product currProduct = productDAO.getElementById(currAuction
					.getProductId());
			currProduct.setAuction(currAuction);
			latestProducts.add(currProduct);

		}
		List<Description> descriptions = descriptionService.getAllItems();
		for (Product currentProduct : latestProducts) {
			setProductDescription(currentProduct, descriptions);
		}
		return latestProducts;
	}

	@Override
	public List<Product> getBySubCategoryId(int subCategoryId) {

		List<Product> productList = productDAO
				.getProductsBySubCategoryId(subCategoryId);
		for (Product product : productList) {
			int productId = product.getIdProduct();
			Auction auction = auctionService.getByProductId(productId);
			Description description = descriptionService
					.getByProductId(productId);

			product.setDescription(description);
			product.setAuction(auction);
		}

		return productList;

	}

	public List<Product> getWonItemsByUserId(int id) {
		List<Product> products = productDAO.getWonElementsByUserId(id);
		for (Product currentProduct : products) {
			Auction auction = auctionService.getByProductId(currentProduct
					.getIdProduct());
			currentProduct.setAuction(auction);
		}

		return products;
	}

	public List<Product> getLostItemsByUserId(int id) {
		List<Product> products = productDAO.getLostElementsByUserId(id);
		for (Product currentProduct : products) {
			Auction auction = auctionService.getByProductId(currentProduct
					.getIdProduct());
			currentProduct.setAuction(auction);
		}

		return products;
	}

	public List<Product> getActiveItemsByUserId(int id) {
		List<Product> products = productDAO.getActiveElementsByUserId(id);
		for (Product currentProduct : products) {
			Auction auction = auctionService.getByProductId(currentProduct
					.getIdProduct());
			currentProduct.setAuction(auction);
		}

		return products;
	}

	public void deleteItemById(int id) {
		productDAO.deleteElementById(id);
	}

	@Override
	public List<Product> getNotClosedBySubCategoryId(int subCategoryId,
			int number) {
		List<Product> productList = productDAO.getNotClosedListBySubCategoryId(
				subCategoryId, number);
		for (Product product : productList) {
			int productId = product.getIdProduct();
			Auction auction = auctionService.getByProductId(productId);
			Description description = descriptionService
					.getByProductId(productId);

			product.setDescription(description);
			product.setAuction(auction);
		}

		return productList;
	}

}
