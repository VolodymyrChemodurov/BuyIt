package com.epam.lab.buyit.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.controller.setters.UserSetter;

public enum Validator {
	FIRST_NAME(UserSetter.FIRST_NAME.getField(), "^[A-Za-z]+{2,15}$", true),
	LAST_NAME(UserSetter.LAST_NAME.getField(),	"^[A-Za-z-]+{3,15}$", true), 
	LOGIN(UserSetter.LOGIN.getField(), "^[A-Za-z0-9_-]{4,15}$", true), 
	PASSWORD(UserSetter.PASSWORD.getField(), "^[\\w_-]{6,15}$", true), 
	CONFIRM_PASSWORD("confirmPassword","^[\\w_-]{6,15}$", false), 
	EMAIL(UserSetter.EMAIL.getField(), "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", true), 
	PHONE(UserSetter.PHONE.getField(),"^\\d{10}$", false), 
	CITY(UserSetter.CITY.getField(), "^[A-Za-z]+$", false), 
	STREET(UserSetter.STREET.getField(), "^[A-Za-z]+$", false), 
	HOUSE(UserSetter.HOUSE.getField(), "^[\\d]{1,3}[A-Za-z]?$", false), 
	FLAT(UserSetter.FLAT.getField(), "^[\\d]{1,3}[A-Za-z]?$", false), 
	ZIP_CODE(UserSetter.ZIP_CODE.getField(),"^\\d{5}$", false),
	PRODUCT_NAME (ProductSetter.PRODUCT_NAME.getField(), "[A-Za-zР-пр-џ0-9 -_()]" , true),
	PRODUCT (ProductSetter.PRODUCT_NAME.getField(), "[A-Za-zР-пр-џ0-9 -_()]" , true),
	START_PRICE(ProductSetter.START_PRICE.getField(), "[0-9]", true),
	BUY_IT_NOW_PRICE(ProductSetter.BUY_IT_NOW_PRICE.getField(), "[0-9]", true),
	COUNT(ProductSetter.COUNT.getField(), "[0-9]", true),
	END_TIME(ProductSetter.END_TIME.getField(), "[]*", true);
	

	private String rule;
	private String field;
	private boolean required;

	private Validator(String fieldName, String regex, boolean required) {
		this.field = fieldName;
		this.rule = regex;
		this.required = required;
	}

	public String getField() {
		return this.field;
	}

	public static Validator getValidator(String name) {
		Validator result = null;
		for (Validator temp : Validator.values()) {
			if (temp.getField().equals(name)) {
				result = temp;
			}
		}
		return result;
	}

	public boolean validate(String input) {
		boolean result = false;
		if (!required && input.equals(""))
			result = true;
		else {
			Pattern pattern = Pattern.compile(rule);
			Matcher matcher = pattern.matcher(input);
			result = matcher.matches();
		}
		return result;
	}
}
