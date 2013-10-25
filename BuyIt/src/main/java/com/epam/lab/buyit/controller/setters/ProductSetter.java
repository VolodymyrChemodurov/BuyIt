package com.epam.lab.buyit.controller.setters;

import java.sql.Timestamp;
import java.util.Map;

import com.epam.lab.buyit.model.Product;

public enum ProductSetter {

	PRODUCT_NAME("productName") {
		public void setField(Product product, String value) {
			product.setName(value);
		}
	},
	SUB_CATEGORY("subCategory") {
		public void setField(Product product, String value) {
			product.setSubCategoryId(Integer.parseInt(value));
		}
	},
	USER_ID("userId") {
		public void setField(Product product, String value) {
			product.setUserId(Integer.parseInt(value));
		}
	},
	DELIVERY("delivery") {
		public void setField(Product product, String value) {
			product.setDelivery(value);
		}
	},
	END_TIME("endTime") {
		public void setField(Product product, String value) {
			product.getAuction().setEndTime(Timestamp.valueOf(value));
		}
	},
	COUNT("count") {
		public void setField(Product product, String value) {
			product.getAuction().setCount(Integer.parseInt(value));
		}
	},
	BUY_IT_NOW_PRICE("buyNowPrice") {
		public void setField(Product product, String value) {
			if (value != null && !value.isEmpty()){
				product.getAuction().setBuyItNow(Double.parseDouble(value));
			} else {
				product.getAuction().setBuyItNow(0);
			}
		}
	},
	START_PRICE("startPrice") {
		public void setField(Product product, String value) {
			if (value != null && !value.isEmpty()){
				product.getAuction().setStartPrice(Double.parseDouble(value));
			} else {
				product.getAuction().setStartPrice(0);
			}
		}
	},
	FEATURES("features") {
		public void setField(Product product, String value) {
			product.getDescription().setFeatures(value);
		}
	},
	DESCRIPTION("description") {
		public void setField(Product product, String value) {
			product.getDescription().setDescText(value);
		}
	},
	;

	private ProductSetter(String field) {
		this.field = field;
	}

	private String field;

	public String getField() {
		return field;
	}

	public abstract void setField(Product product, String value);

	public static ProductSetter getSetter(String value) {
		ProductSetter result = null;
		for (ProductSetter setter : values()) {
			if (setter.getField().equals(value)) {
				result = setter;
			}
		}
		return result;
	}
	
	public static Product setDescriptionFields(Product product, Map<String, String[]> inputValues) {
		for (String current : inputValues.keySet()) {
			ProductSetter setter = ProductSetter.getSetter(current);
			if (setter != null){
				setter.setField(product, inputValues.get(current)[0]);
			}
		}
		return product;
	}

}
