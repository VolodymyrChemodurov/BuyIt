package com.epam.lab.buyit.controller.service.user;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.User;

public interface UserService extends GenericService<User> {

	boolean checkLogin(String login);

	User getUser(String login, String password);

	List<User> getWhoMakeBidInAuction(int auctionId);

	void setBann(String id);

	void setUnbann(String id);

	User getUserByLogin(String login);

	boolean changePasswordByUserId(int id, String newPassword);
}
