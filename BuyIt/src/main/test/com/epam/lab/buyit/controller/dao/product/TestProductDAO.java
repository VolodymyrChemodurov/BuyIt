package com.epam.lab.buyit.controller.dao.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;
import com.epam.lab.buyit.model.User;

public class TestProductDAO {
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	private static CategoryDAO categoryDAO = null;
	private static SubCategoryDAO subCategoryDAO = null; 
	private static Product product = new Product();
	private static Product productUpdate = new Product();
	private static User user = new User();
	private static Category category = new Category();
	private static SubCategory subCategory = new SubCategory();

	@BeforeClass
	public static void setTestData() {
		productDAO = new ProductDAO();
		categoryDAO = new CategoryDAO();
		subCategoryDAO = new SubCategoryDAO();
		userDAO = new UserDAO();
		
		user.setAvatar("");
		user.setBan(false);
		user.setFirstName("Test");
		user.setLastName("Test");
		user.setLogin("test");
		user.setRole(false);
		user.setPassword("test");
		
		
		category.setName("TestCategory");
		subCategory.setName("TestSubCategory");
		subCategory.setCategoryId(categoryDAO.createElement(category));

		product.setDelivery("Has not delivery. It is testing data");
		product.setDeleted(false);
		product.setSubCategoryId(subCategoryDAO.createElement(subCategory));
		product.setName("Test");
		product.setUserId(userDAO.createElement(user));
		
		productUpdate.setDelivery("Has not delivery. It is testing data");
		productUpdate.setDeleted(false);
		productUpdate.setSubCategoryId(subCategoryDAO.createElement(subCategory));
		productUpdate.setName("Update");
		productUpdate.setUserId(userDAO.createElement(user));
	}
	
	@AfterClass
	public static void removeAllTestData(){
		categoryDAO.deleteElementById(subCategory.getCategoryId());
		subCategoryDAO.deleteElementById(product.getSubCategoryId());
		userDAO.deleteElementById(product.getUserId());
	} 

	@After
	public void removeTestData() {
		productDAO.realDeleteElementById(product.getIdProduct());
	}

	@Test
	public void testCreateElement() {
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertNotEquals("Product Id must be not 0", 0, id);
	}

	@Test
	public void testGetElementById() {
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertNotNull("product can't be null", productDAO.getElementById(id));
	}

	@Test
	public void testFindElementByNameCategory() {
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertNotNull("List can't be null", productDAO.findElementByNameCategory(product.getName(), category.getName()));
	}
	
	@Test
	public void testFindElementByCategory(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertNotNull("List can't be null", productDAO.findElementByCategory(category.getName()));
	}
	
	@Test
	public void testFindElementByName(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertNotNull("List can't be null", productDAO.findElementByName(product.getName()));
	}
	
	@Test
	public void testUpdateElement(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		productUpdate.setIdProduct(id);
		productDAO.updateElement(productUpdate);		
		assertEquals("Name not equal Update", "Update", productDAO.getElementById(id).getName());
	}
	
	@Test
	public void testDeleteElementById(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		productDAO.deleteElementById(id);		
		assertNull("Element must be null", productDAO.getElementById(id));
	}
	
	@Test
	public void testGetAllProducts(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		int firstLength = productDAO.getAllProducts().size();
		productDAO.deleteElementById(id);
		int secondLength = productDAO.getAllProducts().size();
		assertEquals("Not correct list length", firstLength - 1, secondLength);
	}
	
	
	@Test
	public void testGetProductsBySubCategoryId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		int firstLength = productDAO.getProductsBySubCategoryId(product.getSubCategoryId()).size();
		productDAO.deleteElementById(id);
		int secondLength = productDAO.getProductsBySubCategoryId(product.getSubCategoryId()).size();
		assertEquals("Not correct list length", firstLength - 1, secondLength);
	}
	
	@Test
	public void testGetCountBySubCategoryId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		int firstLength = productDAO.getCountBySubCategoryId(product.getSubCategoryId());
		productDAO.deleteElementById(id);
		int secondLength = productDAO.getCountBySubCategoryId(product.getSubCategoryId());
		assertEquals("Not correct count", firstLength - 1, secondLength);
	}

	@Test
	public void testGetElementsByUserId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		int size = productDAO.getElementsByUserId(product.getUserId()).size();
		assertEquals("Not correct count", 1, size);
	}
	
	@Test
	public void testGetNotClosedListBySubCategoryId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertTrue("List must be empty", productDAO.getNotClosedListBySubCategoryId(product.getSubCategoryId(), 2).isEmpty());
	}
	
	@Test
	public void testGetWonElementsByUserId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertTrue("List must be empty", productDAO.getWonElementsByUserId(product.getUserId()).isEmpty());
	}
	
	@Test
	public void testGetActiveElementsByUserId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertTrue("List must be empty", productDAO.getActiveElementsByUserId(product.getUserId()).isEmpty());
	}
	
	@Test
	public void testGetBuyElementsByUserId(){
		int id = productDAO.createElement(product);
		product.setIdProduct(id);
		assertTrue("List must be empty", productDAO.getBuyElementsByUserId(product.getUserId()).isEmpty());
	}
}
