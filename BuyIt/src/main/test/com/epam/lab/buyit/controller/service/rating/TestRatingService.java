package com.epam.lab.buyit.controller.service.rating;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.epam.lab.buyit.controller.service.rating.RatingServiceImpl;

public class TestRatingService {
	private static RatingServiceImpl ratingService = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ratingService = new RatingServiceImpl();
	}

	@Test
	public void testGetUserRating() {
		int rating =  ratingService.getUserRating(1);
		assertNotNull(rating);
	}
}
