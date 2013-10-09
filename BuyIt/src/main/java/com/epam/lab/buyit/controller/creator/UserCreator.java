package com.epam.lab.buyit.controller.creator;

import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.lab.buyit.controller.setters.UserSetter;
import com.epam.lab.buyit.model.User;

public class UserCreator {

	public UserCreator(){
		
	}

	public User create(Map<String,String[]> inputMap){
		Map<String,String[]> tempMap = new LinkedHashMap<>(inputMap);
		User createdUser = new User();
		for(UserSetter currentElement: UserSetter.values()){
			String name = currentElement.getField();
			if (name.equals(UserSetter.HOUSE.getField())) {
				StringBuilder builder = new StringBuilder();
				String[] tempInputArray = inputMap.get(name);
				builder.append(tempInputArray[0]).append("/").append(tempInputArray[1]);
				String[] tempArray = {builder.toString()};
				tempMap.put(name, tempArray);
			}
			String value = tempMap.get(currentElement.getField())[0];
			currentElement.setField(createdUser, value);
		}
		return createdUser;
	}
}