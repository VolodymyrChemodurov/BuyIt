package dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.subcategory.SubCategoryDAO;
import com.epam.lab.buyit.model.SubCategory;

public class TestSubCategoryDAO {
	private static SubCategory subCategory = null;
	private static SubCategory newSubCategory = null;
	private static SubCategoryDAO subCategoryDAO = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		subCategory = new SubCategory();
		newSubCategory = new SubCategory();
		subCategoryDAO = new SubCategoryDAO();
		
		subCategory.setCategoryId(1).setName("Test");
		newSubCategory.setCategoryId(2).setName("Test2");
		
	}

	@Test
	public void testGetAllSubCategories() {
		List<SubCategory> subCategoryList = subCategoryDAO.getAllSubCategories();
		assertTrue(subCategoryList.size() > 0);
				
	}
	@Test
	public void testCreateSubCategory(){
		int id = subCategoryDAO.createElement(subCategory);
		assertNotNull("Id not null", id);
	}
	@Test
	public void testGetElementById(){
		int id = subCategoryDAO.createElement(subCategory);
		SubCategory currentSubCategory = subCategoryDAO.getElementById(id);
		assertNotNull(currentSubCategory);
	}
	@Test
	public void testUpdateElement(){
		int id = subCategoryDAO.createElement(subCategory);
		newSubCategory.setIdSubCategory(id);
		subCategoryDAO.updateElement(newSubCategory);
		
		assertEquals(newSubCategory.getName(), subCategoryDAO.getElementById(id).getName());
	}
	@Test 
	public void testGetAllSubCategoriesByCategoryId(){
	List<SubCategory> subCategoryList = subCategoryDAO.getAllSubCategoriesByIdCategory(subCategory.getCategoryId());
	assertTrue(subCategoryList.size() >= 0);
	}
}
