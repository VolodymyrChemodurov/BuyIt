package com.epam.lab.buyit.controller.dao.image;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Image;

public interface ImageDAOInterface extends GenericDAO<Image> {
	
	List<Image> getImagesByDescriptionId(int id); 
}
