package com.epam.lab.buyit.controller.dao.image;

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
import com.epam.lab.buyit.controller.dao.image.ImageDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Category;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Image;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.SubCategory;
import com.epam.lab.buyit.model.User;

public class TestImageDAO {
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	private static CategoryDAO categoryDAO = null;
	private static SubCategoryDAO subCategoryDAO = null;
	private static ImageDAO imageDAO = null;
	private static DescriptionDAO descriptionDAO = null;
	private static Product product = new Product();
	private static Description description = new Description();
	private static Image image = new Image();
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
		imageDAO = new ImageDAO();
		
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
		
		image.setPath("testpath");
		image.setDescriptionId(descriptionDAO.createElement(description));
	}
	
	@AfterClass
	public static void removeAllTestData(){
		categoryDAO.deleteElementById(subCategory.getCategoryId());
		subCategoryDAO.deleteElementById(product.getSubCategoryId());
		descriptionDAO.deleteElementById(image.getDescriptionId());
		productDAO.deleteElementById(description.getProductId());
		userDAO.deleteElementById(product.getUserId());
	} 

	@After
	public void removeTestData() {
		imageDAO.deleteElementById(image.getIdImage());
	}
	
	@Test
	public void testCreateElement() {
		int id = imageDAO.createElement(image);
		image.setIdImage(id);
		assertNotEquals("Image Id must be not 0", 0, id);
	}
	
	@Test
	public void testGetElementById() {
		int id = imageDAO.createElement(image);
		image.setIdImage(id);
		assertNotNull("Image can't be null", imageDAO.getElementById(id));
	}
	
	@Test
	public void testUpdateElement() {
		int id = imageDAO.createElement(image);
		image.setIdImage(id);
		image.setPath("Update");
		imageDAO.updateElement(image);
		assertEquals("Image path must be Update", "Update", imageDAO.getElementById(id).getPath());
	}
	
	@Test
	public void testDeleteElement() {
		int id = imageDAO.createElement(image);
		image.setIdImage(id);
		imageDAO.deleteElementById(id);
		assertNull("Image must be null", imageDAO.getElementById(id));
	}
	
	@Test
	public void testGetImagesByDescriptionId() {
		int id = imageDAO.createElement(image);
		image.setIdImage(id);
		int firstLength = imageDAO.getImagesByDescriptionId(image.getDescriptionId()).size();
		imageDAO.deleteElementById(id);
		int secondLength = imageDAO.getImagesByDescriptionId(image.getDescriptionId()).size();
		assertEquals("Not correct count", firstLength - 1, secondLength);
		
	}
	

	
}
