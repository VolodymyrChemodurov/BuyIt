package com.epam.lab.buyit.controller.utils.builder.jsonbuilder.adapters;

import java.lang.reflect.Type;

import com.epam.lab.buyit.model.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class UserSerializationAdapter implements JsonSerializer<User> {

	@Override
	public JsonElement serialize(User user, Type arg1, JsonSerializationContext arg2) {
		JsonObject object = new JsonObject();
		object.addProperty("userId", user.getIdUser());
		object.addProperty("firstName", user.getFirstName());
		object.addProperty("lastName", user.getLastName());
		object.addProperty("login", user.getLogin());
		object.addProperty("role", user.getRole());
		object.addProperty("phone", user.getContact().getPhone());
		object.addProperty("email", user.getContact().getEmail());
		return object;
	}

}
