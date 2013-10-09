package com.epam.lab.buyit.controller.jsonbuilder;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSerializer;

public class JSONBuilder {
	private static final Logger LOGGER = Logger.getLogger(JSONBuilder.class);

	public static <T> JSONObject buildJSONObject(T source,
			JsonSerializer<T> adapter) {
		Gson json = new GsonBuilder().registerTypeAdapter(source.getClass(),
				adapter).create();
		String jsonString = json.toJson(source);
		JSONObject jsonObject = new JSONObject();
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

	public static <T> JSONObject buildbuildJSONObject(List<T> source,
			JsonSerializer<List<T>> adapter) {
		
		Gson json = new GsonBuilder().registerTypeAdapter(ArrayList.class,
				adapter).create();
		String jsonString = json.toJson(source);
		JSONObject jsonObject = new JSONObject();
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
