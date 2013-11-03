package com.epam.lab.buyit.controller.service.rating;

import java.util.List;

import com.epam.lab.buyit.controller.dao.rating.RatingDAO;
import com.epam.lab.buyit.model.Rating;

public class RatingServiceImpl implements RatingService {
	private RatingDAO ratingDAO;
	
	public RatingServiceImpl() {
		ratingDAO = new RatingDAO();
	}
	
	@Override
	public Rating getItemById(int id) {
		return ratingDAO.getElementById(id);
	}

	@Override
	public List<Rating> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rating createItem(Rating item) {
		int id = ratingDAO.createElement(item);
		item.setId(id);
		return item;
	}

	@Override
	public Rating updateItem(Rating item) {
		ratingDAO.updateElement(item);
		return item;
	}

	@Override
	public List<Rating> getUserMarks(int userId) {
		return ratingDAO.getUserRatings(userId);
	}

	@Override
	public int getUserRating(int userId) {
		List<Rating> marks = ratingDAO.getUserRatings(userId);
		int total = 0;
		for(Rating currentMark: marks) {
			total += currentMark.getRating();
		}
		int result = 0;
		if(marks.size() != 0)
			result = total/marks.size();
		return result;
	}

	@Override
	public Rating findMark(int fromId, int toId) {
		return ratingDAO.findMark(fromId, toId);
	}

	@Override
	public int getUserMarksCount(int id) {
		return ratingDAO.getUserMarksCount(id);
	}


}
