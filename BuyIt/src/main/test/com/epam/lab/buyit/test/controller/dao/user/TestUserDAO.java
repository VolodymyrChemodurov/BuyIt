package com.epam.lab.buyit.test.controller.dao.user;

import java.util.List;

import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.User;

public class TestUserDAO extends Assert {
	private static UserDAO userDao;
	private static User user;
	private static int id;

	@BeforeClass
	public static void setUpUserDAO() throws NamingException {
		userDao = new UserDAO();
		user = new User();

		user.setAvatar("").setBan(false).setBidList(null).setContact(null)
				.setFirstName("Nick").setLastName("Dandy").setLogin("Brut")
				.setPassword("1111").setProductList(null).setRole(false);
	}

	@AfterClass
	public static void removeUserDAO() {
		userDao = null;
		user = null;
	}

	@Test
	public void testCreateElement() {
		id = userDao.createElement(user);
		assertNotEquals("Must be not zero", 0, id);
	}

	@Test
	public void testGetUserByLogin() {
		User desiredUser = userDao.getUserByLogin(user.getLogin());
		assertNotNull("Must be not NULL", desiredUser);
	}

	@Test
	public void testGetUser() {
		User desiredUser = userDao.getUser(user.getLogin(), user.getPassword());
		assertNotNull("Must be not NULL", desiredUser);
	}

	@Test
	public void testGetElementById() {
		User desiredUser = userDao.getElementById(id);
		assertNotNull("Must be not NULL", desiredUser);
	}

	@Test
	public void testUpdateElement() {
		user.setFirstName("Peter");
		userDao.updateElement(user);
		assertEquals("Peter", user.getFirstName());
	}

	@Test
	public void testGetAllUsers() {
		List<User> userList = userDao.getAllUsers();
		assertNotNull("Not NULL", userList);
	}

	@Test
	public void testCheckLogin() {
		assertTrue(userDao.checkLogin(user.getLogin()));
	}

	@Test
	public void testChangePassword() {
		assertTrue(userDao.changePasswordByUserId(id, "2222"));
	}

}
