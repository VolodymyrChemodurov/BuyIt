package com.epam.lab.buyit.controller.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.epam.lab.buyit.controller.setters.UserSetter;

public enum Validator {
	FIRST_NAME(UserSetter.FIRST_NAME.getField(), "^[A-Z][a-z]+{2,15}$"),
//	FIRST_NAME(UserSetter.FIRST_NAME.getField(), "*"),
	LAST_NAME(UserSetter.LAST_NAME.getField(), "^[A-Z][a-z-]+{3,15}$"),
//	LAST_NAME(UserSetter.LAST_NAME.getField(), "*"),
	LOGIN(UserSetter.LOGIN.getField(), "^[a-z0-9_-]{4,15}$"),
	PASSWORD(UserSetter.PASSWORD.getField(), "^[\\w_-]{6,15}$"),
	CONFIRM_PASSWORD("confirmPassword", "^[\\w_-]{6,15}$"),
	EMAIL(UserSetter.EMAIL.getField(), "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"),
	PHONE(UserSetter.PHONE.getField(), "^\\d{10}$"),
	CITY(UserSetter.CITY.getField(), "^[A-Za-z]+$"),
//	CITY(UserSetter.CITY.getField(), "*"),
	STREET(UserSetter.STREET.getField(), "^[A-Za-z]+$"),
//	STREET(UserSetter.STREET.getField(), "*"),
	HOUSE(UserSetter.HOUSE.getField(), "^[\\d]{1,3}[a-z]*\\/[\\d]{1,3}[a-z]*$"),
//	HOUSE(UserSetter.HOUSE.getField(), "^[\\d]{1,3}[*]*\\/[\\d]{1,3}[*]*$"),
	ZIP_CODE(UserSetter.ZIP_CODE.getField(),"^\\d{5}$");

	private String rule;
	private String field;

	private Validator(String fieldName, String regex) {
		this.field = fieldName;
		this.rule = regex;
	}
	
	public String getField(){
		return this.field;
	}

	public boolean validate(String input) {
		Pattern pattern = Pattern.compile(rule);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
