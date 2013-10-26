package com.epam.lab.buyit.controller.dao.rating;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Rating;

public interface RatingDAOInterface extends GenericDAO<Rating> {

	List<Rating> getUserRatings(int userId);
	
	Rating findMark(int fromId, int toId);
}
