package com.epam.lab.buyit.controller.dao.contact;

import java.util.List;

import com.epam.lab.buyit.controller.dao.GenericDAO;
import com.epam.lab.buyit.model.Contact;

public interface ContactDAOInterface extends GenericDAO<Contact>{

	List<Contact> getAllContacts();
}
