package com.epam.lab.buyit.controller.jsonbuilder.adapters;

import java.lang.reflect.Type;
import java.util.List;

import com.epam.lab.buyit.model.User;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class UserListSerializationAdapter implements JsonSerializer<List<User>>{

	@Override
	public JsonElement serialize(List<User> users, Type type,
			JsonSerializationContext context) {
		
		JsonObject json = new JsonObject();
		UserSerializationAdapter adapter = new UserSerializationAdapter();
		JsonArray array = new JsonArray();
		for(User user: users) {
			array.add(adapter.serialize(user, type, context));
		}
		json.add("users", array);
		
		return json;
	}

}
