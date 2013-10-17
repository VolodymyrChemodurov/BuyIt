package com.epam.lab.buyit.controller.validator;

import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class UserValidation {
	private static final Logger LOGGER = Logger.getLogger(UserValidation.class);
	
	public static boolean checkingInput(Map<String, String[]> inputMap) {
		boolean result = true;
		for (Validator currentElement : Validator.values()) {
			String name = currentElement.getField();
			result = currentElement.validate(inputMap.get(name)[0]);
			if (!result) {
				break;
			}
		}
		result = result
				&& inputMap.get(Validator.PASSWORD.getField())[0]
						.equals(inputMap.get(Validator.CONFIRM_PASSWORD
								.getField())[0]);
		return result;
	}
	
	public static boolean checkingInput(JSONObject json) {
		boolean result = true;
		for (Validator currentElement : Validator.values()) {
			String name = currentElement.getField();
			try {
				result = currentElement.validate(json.getString(name));
			} catch (JSONException e) {
				LOGGER.error(e);
			}
			if (!result) {
				break;
			}
		}
		return result;
	}
}
