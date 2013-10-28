package com.epam.lab.buyit.controller.validator;

import java.util.Map;

import org.apache.log4j.Logger;

public class ProductValidation {
	private static final Logger LOGGER = Logger.getLogger(ProductValidation.class);

	public static boolean checkingInputValues(Map<String, String[]> inputMap) {
		boolean result = true;
		for (String current : inputMap.keySet()) {
			Validator validator = Validator.getValidator(current);
			if (validator != null) {
				result = validator.validate(inputMap.get(current)[0]);
				LOGGER.info(current + " validation " + (result ? "successful" : "fail"));
			}
			if (!result) {
				break;
			}
		}
		return result;
	}

}
