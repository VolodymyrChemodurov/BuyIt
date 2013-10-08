package com.epam.lab.buyit.controller.service.description;

import com.epam.lab.buyit.controller.service.GenericService;
import com.epam.lab.buyit.model.Description;

public interface DescriptionService extends GenericService<Description> {

	Description getByProductId(int productId);
}
