package com.epam.lab.buyit.controller.service.image;

import java.util.ArrayList;
import java.util.List;

import com.epam.lab.buyit.controller.dao.image.ImageDAO;
import com.epam.lab.buyit.model.Image;

public class ImageServiceImpl implements ImageService {

	private ImageDAO imageDAO;

	public ImageServiceImpl() {
		imageDAO = new ImageDAO();
	}

	@Override
	public Image getItemById(int id) {
		return imageDAO.getElementById(id);
	}

	@Override
	public List<Image> getAllItems() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Image createItem(Image item) {
		int idImage = imageDAO.createElement(item);
		item.setIdImage(idImage);
		return item;
	}

	@Override
	public Image updateItem(Image item) {
		imageDAO.updateElement(item);
		return item;
	}

	@Override
	public List<Image> getImagesByDescriptionId(int id) {
		return imageDAO.getImagesByDescriptionId(id);
	}

	@Override
	public List<String> getImagesUrl() {
		List<String> result = new ArrayList<String>();
		result.add("themes/images/carousel/1.png");
		result.add("themes/images/carousel/2.png");
		result.add("themes/images/carousel/3.png");
		result.add("themes/images/carousel/4.png");
		return result;
	}

}
