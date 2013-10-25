package com.epam.lab.buyit.controller.email.textlines;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

public class TextLineConteiner {
	private static final Logger LOGGER = Logger
			.getLogger(TextLineConteiner.class);

	private String password = null;

	private User buyer = null;
	private User seller = null;
	private Product product = null;
	private int count = 0;

	public String getBuyerLine() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Name: ").append(buyer.getFirstName())
				.append(";<br>  Email: ").append(buyer.getContact().getEmail())
				.append(";<br> ");
		if (!buyer.getContact().getPhone().equals("")) {
			strBuilder.append("Phone: ").append(buyer.getContact().getPhone())
					.append("<br>");
		}
		return strBuilder.toString();
	}

	public String getBuyerLink() {
		return "http://localhost:8080/BuyIt/user_wall?id=" + buyer.getIdUser();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSellerGreatingLine() {
		return "Hello " + seller.getFirstName() + " !!!";
	}

	public String getBuyerGreatingLine() {
		return "Hello " + buyer.getFirstName() + " !!!";
	}

	public String getProductLine() {
		return product.getName();
	}

	public String getProductLink() {
		return "http://localhost:8080/BuyIt/productDetails?id="
				+ product.getIdProduct();
	}

	public String getSellerLine() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Name: ").append(seller.getFirstName())
				.append(";<br>  Email: ")
				.append(seller.getContact().getEmail()).append(";<br> ");
		if (!seller.getContact().getPhone().equals("")) {
			strBuilder.append("Phone: ").append(seller.getContact().getPhone())
					.append("<br>");
		}
		return strBuilder.toString();
	}

	public String getSellerLink() {
		return "http://localhost:8080/BuyIt/user_wall?id=" + seller.getIdUser();
	}

	public String getBuyItNowPrice() {
		return "" + (product.getAuction().getBuyItNow()*count);
	}

	public String getAuctionPrice() {
		return "" + product.getAuction().getCurrentPrice();
	}

	public String getCount() {
		return "" + count;
	}

	public TextLineConteiner setBuyer(User buyer) {

		this.buyer = buyer;
		return this;
	}

	public TextLineConteiner setSeller(User seller) {
		this.seller = seller;
		return this;
	}

	public TextLineConteiner setProduct(Product product) {
		this.product = product;
		return this;
	}

	public TextLineConteiner setCount(int count) {
		this.count = count;
		return this;
	}

}
