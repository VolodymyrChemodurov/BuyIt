package com.epam.lab.buyit.controller.creator;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.model.Product;

public class ProductCreator {
	private final static Logger LOGGER = Logger.getLogger(UserCreator.class);

	public Product create(Map<String, String[]> inputMap) {
		Product createdProduct = new Product();
		for(ProductSetter currentElement: ProductSetter.values()){
			String[] value = inputMap.get(currentElement.getField());
			if(value != null){
				currentElement.setField(createdProduct, value[0]);
			} else {
				currentElement.setField(createdProduct, null);
			}
		}
		setDefaultValues(createdProduct);
		return createdProduct;
	}
	
	private void setDefaultValues(Product product) {
		Date date = new Date();
		product.setDeleted(false);
		if (product.getAuction().getBuyItNow() != 0 && product.getAuction().getStartPrice() == 0){
			product.getAuction().setCurrentPrice(0);
		} else {			
			product.getAuction().setCurrentPrice(product.getAuction().getStartPrice());
		}
		product.getAuction().setStatus("inProgress");
		product.getAuction().setStartTime(new Timestamp(date.getTime()));
	}
}
