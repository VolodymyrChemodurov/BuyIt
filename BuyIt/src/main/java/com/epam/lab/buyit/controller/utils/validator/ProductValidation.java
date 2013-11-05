package com.epam.lab.buyit.controller.utils.validator;

import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.utils.setters.ProductSetter;

public class ProductValidation {
	private static final Logger LOGGER = Logger.getLogger(ProductValidation.class);

	public static boolean checkingInputValues(Map<String, String[]> inputMap) {
		boolean result = true;
		for (String current : inputMap.keySet()) {
			Validator validator = Validator.getValidator(current);
			if (validator != null) {
				if ( (validator.getField().equals(ProductSetter.BUY_IT_NOW_PRICE.getField()) && inputMap.get("buyNowCheck") == null) ||
						(validator.getField().equals(ProductSetter.START_PRICE.getField()) && inputMap.get("auctionCheck") == null)){
					validator.setRequired(false);
				}
				String i = inputMap.get(current)[0];
				result = validator.validate(i);
				LOGGER.info(current + " validation " + (result ? "successful" : "fail"));
			}
			if (!result) {
				break;
			}
		}
		return result;
	}

}
