package com.epam.lab.buyit.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.lab.buyit.controller.setters.UserSetter;

public enum Validator {
	FIRST_NAME(UserSetter.FIRST_NAME.getField(), "^[A-Z][a-z]+{2,15}$", true),
	LAST_NAME(UserSetter.LAST_NAME.getField(), "^[A-Z][a-z-]+{3,15}$", true),
	LOGIN(UserSetter.LOGIN.getField(), "^[a-z0-9_-]{4,15}$", true),
	PASSWORD(UserSetter.PASSWORD.getField(), "^[\\w_-]{6,15}$", true),
	CONFIRM_PASSWORD("confirmPassword", "^[\\w_-]{6,15}$", false),
	EMAIL(UserSetter.EMAIL.getField(), "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", true),
	PHONE(UserSetter.PHONE.getField(), "^\\d{10}$", false),
	CITY(UserSetter.CITY.getField(), "^[A-Za-z]+$", false),
	STREET(UserSetter.STREET.getField(), "^[A-Za-z]+$", false),
	HOUSE(UserSetter.HOUSE.getField(), "^[\\d]{1,3}[a-z]?$", false),
	FLAT(UserSetter.FLAT.getField(), "^[\\d]{1,3}[a-z]?$", false),
	ZIP_CODE(UserSetter.ZIP_CODE.getField(),"^\\d{5}$", false);

	private String rule;
	private String field;
	private boolean required;

	private Validator(String fieldName, String regex, boolean required) {
		this.field = fieldName;
		this.rule = regex;
		this.required = required;
	}
	
	public String getField(){
		return this.field;
	}

	public boolean validate(String input) {
		boolean result = false;
		if(!required && input.equals(""))
			result = true;
		else { 
			Pattern pattern = Pattern.compile(rule);
			Matcher matcher = pattern.matcher(input);
			result = matcher.matches();
		}
		return result;
	}
}
