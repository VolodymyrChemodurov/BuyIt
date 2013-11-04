package com.epam.lab.buyit.controller.dao.description;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.category.CategoryDAO;
import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;
import com.epam.lab.buyit.model.User;

public class TestDescriptionDAO {
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	private static CategoryDAO categoryDAO = null;
	private static SubCategoryDAO subCategoryDAO = null;
	private static DescriptionDAO descriptionDAO = null;
	private static Product product = new Product();
	private static Description description = new Description();
	private static User user = new User();
	private static Category category = new Category();
	private static SubCategory subCategory = new SubCategory();

	@BeforeClass
	public static void setTestData() {
		productDAO = new ProductDAO();
		categoryDAO = new CategoryDAO();
		subCategoryDAO = new SubCategoryDAO();
		userDAO = new UserDAO();
		descriptionDAO = new DescriptionDAO();
		
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
		
		description.setProductId(productDAO.createElement(product));
		description.setDescText("TEST");
		description.setFeatures("TEST");
		
	}
	
	@AfterClass
	public static void removeAllTestData(){
		categoryDAO.deleteElementById(subCategory.getCategoryId());
		subCategoryDAO.deleteElementById(product.getSubCategoryId());
		productDAO.deleteElementById(description.getProductId());
		userDAO.deleteElementById(product.getUserId());
	} 

	@After
	public void removeTestData() {
		descriptionDAO.deleteElementById(description.getIdDescription());
	}
	
	@Test
	public void testCreateElement() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		assertNotEquals("description Id must be not 0", 0, id);
	}
	
	@Test
	public void testGetElementById() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		assertNotNull("Description can't be null", descriptionDAO.getElementById(description.getProductId()));
	}
	
	@Test
	public void testUpdateElement() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		description.setDescText("Update");
		descriptionDAO.updateElement(description);
		assertEquals("Description features must be Update", "Update", descriptionDAO.getElementById(description.getProductId()).getDescText());
	}
	
	@Test
	public void testDeleteElement() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		descriptionDAO.deleteElementById(id);
		assertNull("Image must be null", descriptionDAO.getElementById(description.getProductId()));
	}
	
	@Test
	public void testGetAllDescriptions() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		assertNotNull("Description can't be null", descriptionDAO.getAllDescriptions());
	}
	
	@Test
	public void testGetDescriptionByProductId() {
		int id = descriptionDAO.createElement(description);
		description.setIdDescription(id);
		assertNotNull("Description can't be null", descriptionDAO.getDescriptionByProductId(description.getProductId()));
	}
	

	
}
