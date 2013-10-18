package com.epam.lab.buyit.controller.service.image;

import java.util.List;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Image;

public interface ImageService extends GenericService<Image> {

	List<Image> getImagesByDescriptionId(int id);

	List<String> getImagesUrl();

}
