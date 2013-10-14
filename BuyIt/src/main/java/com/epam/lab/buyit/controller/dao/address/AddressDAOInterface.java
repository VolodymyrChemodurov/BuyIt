package com.epam.lab.buyit.controller.dao.address;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Address;

public interface AddressDAOInterface extends GenericDAO<Address>{

	public List<Address> getAllAddress();
}
