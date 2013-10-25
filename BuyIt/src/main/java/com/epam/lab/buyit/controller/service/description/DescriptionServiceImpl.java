package com.epam.lab.buyit.controller.service.description;

import java.util.List;

import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.service.image.ImageServiceImpl;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Image;

public class DescriptionServiceImpl implements DescriptionService {
	private DescriptionDAO descriptionDAO;
	private ImageServiceImpl imageService;

	public DescriptionServiceImpl() {
		descriptionDAO = new DescriptionDAO();
		imageService = new ImageServiceImpl();
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

		List<Image> imageList = item.getItemPhotos();
		for (Image image : imageList) {
			image.setDescriptionId(id);
			imageService.createItem(image);
		}
		return item;
	}

	@Override
	public Description updateItem(Description item) {
		descriptionDAO.updateElement(item);
		List<Image> imageList = item.getItemPhotos();
		for (Image image : imageList) {
			image.setDescriptionId(item.getIdDescription());
			imageService.updateItem(image);
		}
		return item;
	}

	@Override
	public Description getByProductId(int productId) {
		Description description = descriptionDAO
				.getDescriptionByProductId(productId);
		description.setItemPhotos(imageService
				.getImagesByDescriptionId(description.getIdDescription()));
		return description;
	}

}
