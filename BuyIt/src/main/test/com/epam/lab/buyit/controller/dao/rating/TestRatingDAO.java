package com.epam.lab.buyit.controller.dao.rating;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.dao.rating.RatingDAO;
import com.epam.lab.buyit.model.Rating;

public class TestRatingDAO {
	private static RatingDAO ratingDAO = null;
	private static Rating rating = null;
	private static Rating newRating = null;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	ratingDAO = new RatingDAO();
	rating = new Rating();
	newRating = new Rating();
	
	rating.setFromId(1).setRating(3).setUserId(1);
	rating.setFromId(2).setRating(2).setUserId(2);	
	
	}

	@Test
	public void testCreatElement() {
		int id = ratingDAO.createElement(rating);
		assertNotNull(id);
	}
	@Test
	public void testGetElementById(){ 
		int id = ratingDAO.createElement(rating);
		Rating currentRating = ratingDAO.getElementById(id);
		assertNotNull(currentRating);
		
	}
	@Test
	public void testUpdateElement(){
		int id = ratingDAO.createElement(rating);
		newRating.setId(id);
		ratingDAO.updateElement(newRating);
	}
	@Test
	public void testGetUserRating(){
		List<Rating> ratingList = ratingDAO.getUserRatings(rating.getUserId());
		assertTrue(ratingList.size() >= 0);
	}
	@Test
	public void testFindMark(){
		Rating currRating = ratingDAO.findMark(rating.getFromId(), rating.getUserId());
		assertNotNull(currRating);
	}

}
