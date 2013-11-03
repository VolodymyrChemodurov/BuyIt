package com.epam.lab.buyit.controller.service.rating;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Rating;

public interface RatingService extends GenericService<Rating> {

	List<Rating> getUserMarks(int userId);
	
	int getUserRating(int userId);
	
	Rating findMark(int fromId, int toId);
	
	int getUserMarksCount(int id);
}
