package com.epam.lab.buyit.controller.jsonbuilder;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;

public class JSONBuilder {
	private static final Logger LOGGER = Logger.getLogger(JSONBuilder.class);

	public static JSONObject buildJSONOblect(Object source) {
		Gson json = new Gson();
		String jsonString = json.toJson(source);
		JSONObject jsonObject = null;
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("Can't serealize ").append(source)
					.append(" to JSON. ").append(e);
			LOGGER.error(errorMessage);
		}
		
		return jsonObject;
	}
}
