package com.epam.lab.buyit.controller.dao.user;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.User;

public interface UserDAOInterface extends GenericDAO<User> {
	
	List<User> getAllUsers();
	
	boolean checkLogin(String login);
	
	User getUser(String login, String password);
}
