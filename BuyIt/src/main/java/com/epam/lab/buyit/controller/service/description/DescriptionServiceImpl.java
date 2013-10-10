package com.epam.lab.buyit.controller.service.description;

import java.util.List;

import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.image.ImageDAO;
import com.epam.lab.buyit.model.Description;

public class DescriptionServiceImpl implements DescriptionService {
	private DescriptionDAO descriptionDAO;
	private ImageDAO imageDAO;

	public DescriptionServiceImpl() {
		descriptionDAO = new DescriptionDAO();
		imageDAO = new ImageDAO();
	}

	@Override
	public Description getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Description> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Description createItem(Description item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Description updateItem(Description item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Description getByProductId(int productId) {
		Description description = descriptionDAO
				.getDescriptionByProductId(productId);
		description.setItemPhotos(imageDAO.getImagesByDescriptionId(description
				.getIdDescription()));
		return description;
	}

}
