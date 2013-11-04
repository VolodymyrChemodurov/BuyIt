package com.epam.lab.buyit.controller.service.subcategory;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.service.subcategory.SubCategoryServiceImpl;
import com.epam.lab.buyit.model.SubCategory;

public class TestSubCategoryService {
	private static SubCategoryServiceImpl subCategoryService = null;
	private static SubCategory subCategory = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		subCategoryService = new SubCategoryServiceImpl();
		subCategory = new SubCategory();
	}

	@Test
	public void testGetItemById() {
		subCategory = subCategoryService.getItemById(1);
		assertNotNull(subCategory);

	}

	@Test
	public void testGetItemByIdProductList() {
		subCategory = subCategoryService.getItemById(1);
		assertNotNull(subCategory.getProducts());

	}

	@Test
	public void testGetAllItems() {
		List<SubCategory> subCategoryList = subCategoryService.getAllItems();
		assertTrue(subCategoryList.size() >= 1);
	}
	@Test
	public void testGetAllItemsByCategoryId(){ 
		List<SubCategory> subCategoryList = subCategoryService.getAllItemsByCategoryId(subCategory.getCategoryId());
		assertTrue(subCategoryList.size() >=1);
	}
	@Test
	public void testGetWithProductSelection(){
		SubCategory currentSubCategory =subCategoryService.getWithProductSelection(subCategory.getIdSubCategory(), 0, 5);
		assertNotNull(currentSubCategory);
	}
	@Test
	public void testGetNotClosedByCategoryId(){
		List<SubCategory> subCategories = subCategoryService.getNotClosedByCategoryId(subCategory.getCategoryId(), 5);
		assertNotNull(subCategories);
	}
	
}
