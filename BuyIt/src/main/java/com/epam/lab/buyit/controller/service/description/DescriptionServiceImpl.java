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
		return descriptionDAO.getElementById(id);
	}

	@Override
	public List<Description> getAllItems() {
		return descriptionDAO.getAllDescriptions();
	}

	@Override
	public Description createItem(Description item) {
		int id = descriptionDAO.createElement(item);
		item.setIdDescription(id);
		return item;
	}

	@Override
	public Description updateItem(Description item) {
		descriptionDAO.updateElement(item);
		return item;
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
