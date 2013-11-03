package com.epam.lab.buyit.controller.dao.category;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import com.epam.lab.buyit.controller.Creator;
import com.epam.lab.buyit.model.Category;

public class CategoryDAOTest {

	private CategoryDAO categoryDAO = new CategoryDAO();
	private Creator creator = new Creator();

	@Test
	public void testCreate() {
		int id = creator.createCategory();
		assertNotNull(id);
	}

	@Test
	public void testGetById() {
		int id = creator.createCategory();
		Category testCategory = categoryDAO.getElementById(id);
		assertNotNull(testCategory);
	}

	@Test
	public void testUpdate() {
		int id = creator.createCategory();
		Category testCategory = categoryDAO.getElementById(id);
		testCategory.setName("New Test");
		categoryDAO.updateElement(testCategory);
		Category newTestCategory = categoryDAO.getElementById(id);
		assertEquals("New Test", newTestCategory.getName());
	}

	@Test
	public void testGetAllCategories() {
		List<Category> testList = categoryDAO.getAllCategories();
		assertNotNull(testList);
	}

}
