package com.epam.lab.buyit.controller.dao.description;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Description;

public interface DescriptionDAOInterface extends GenericDAO<Description> {

	List<Description> getAllDescriptions();

	Description getDescriptionByProductId(int productId);

}
