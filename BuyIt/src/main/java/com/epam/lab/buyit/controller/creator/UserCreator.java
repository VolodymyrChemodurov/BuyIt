package com.epam.lab.buyit.controller.creator;

import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.lab.buyit.controller.setters.UserSetter;
import com.epam.lab.buyit.model.User;

public class UserCreator {

	public UserCreator() {

	}

	public User create(Map<String, String[]> inputMap) {
		Map<String, String[]> tempMap = new LinkedHashMap<>(inputMap);
		User createdUser = new User();
		for(UserSetter currentElement: UserSetter.values()){
			String value = tempMap.get(currentElement.getField())[0];
			currentElement.setField(createdUser, value);
		}
		createdUser.setAvatar("bootstrap/img/avatars/user-icon.png");
		createdUser.setBan(false);
		return createdUser;
	}
}
