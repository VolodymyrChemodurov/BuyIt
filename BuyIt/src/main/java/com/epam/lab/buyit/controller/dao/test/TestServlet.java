package com.epam.lab.buyit.controller.dao.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.dao.address.AddressDAO;
import com.epam.lab.buyit.controller.dao.contact.ContactDAO;
import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.image.ImageDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.dao.user.UserDAO;
import com.epam.lab.buyit.model.Address;
import com.epam.lab.buyit.model.Contact;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Image;
import com.epam.lab.buyit.model.Product;
import com.epam.lab.buyit.model.User;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(TestServlet.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		contactDAOTest();
	}

	private void productDAOTest() {
		ProductDAO dao = new ProductDAO();
		
		Product pr = new Product();
		
		for(int i = 1; i <=4; i++) {
			pr = dao.getElementById(i);
			LOGGER.info(pr);
		}
		
		LOGGER.info("CREATE TEST");
		pr.setName("NEW");
		pr.setSubCategoryId(2);
		pr.setUserId(2);
		int key = dao.createElement(pr);
		
		for(int i = 1; i <= key; i++) {
			pr = dao.getElementById(i);
			LOGGER.info(pr);
		}
	}
	
	private void descrDAOTest() {
		DescriptionDAO dao = new DescriptionDAO();
		
		Description desc = new Description();
		
		for(int i = 1; i <= 3; i++) {
			desc = dao.getElementById(i);
			LOGGER.info(desc);
		}
	}
	
	private void imageDAOTest() {
		ImageDAO dao = new ImageDAO();
		
		//Image image = new Image();
		
		for(int i = 1; i <= 3; i++) {
			List<Image> images = dao.getImagesByDescriptionId(i);
			for(int j = 0; j < images.size(); j++)
				LOGGER.info(images.get(j));
		}
	}
	
	private void userDAOTest() {
		UserDAO dao = new UserDAO();
		
		User user = new User();
		
		LOGGER.info("GET TEST");
		for(int i = 1; i <= 5; i++) {
			user = dao.getElementById(i);
			LOGGER.info(user);
		}
		
		LOGGER.info("CREATE TEST");
		user.setFirstName("CHEMO").setLastName("CHEMO").setLogin("LOGIN").setPassword("PASS");
		int id = dao.createElement(user);
		LOGGER.info("GENERATED KEY: " + id);
		
		for(int i = 1; i <= 6; i++) {
			user = dao.getElementById(i);
			LOGGER.info(user);
		}
		
		LOGGER.info("UPDATE TEST");
		user = dao.getElementById(5);
		user.setLastName("DEndi");
		dao.updateElement(user);
		
		for(int i = 1; i <= 6; i++) {
			user = dao.getElementById(i);
			LOGGER.info(user);
		}
	}
	
	private void contactDAOTest() {
		ContactDAO dao = new ContactDAO();
		Contact contact = new Contact();
		
		LOGGER.info("CREATE TEST");
		contact.setEmail("chemo@gmail.com").setPhone("093842132").setUserId(5);
		dao.createElement(contact);
		
		LOGGER.info("GET BY ID TEST");
		for(int i = 1; i <= 5; i++) {
			contact = dao.getElementById(i);
			LOGGER.info(contact);
		}
		
		LOGGER.info("UPDATE TEST");
		contact.setEmail("emaaiiiiilll").setPhone("1111111111").setUserId(5);
		dao.updateElement(contact);
		
		for(int i = 1; i <= 5; i++) {
			contact = dao.getElementById(i);
			LOGGER.info(contact);
		}
		
	}
	
	private void addressDAOTest() {
		AddressDAO dao = new AddressDAO();
		
		LOGGER.info("CREATE TEST:");
		Address adr = new Address();
		adr.setCity("Lviv").setHouse("45").setRegion("Lvivska")
				.setStreet("Djerelna").setZipCode("79007").setContactId(4);
		int id = dao.createElement(adr);
		LOGGER.info("Generated key = " + id);
		
		LOGGER.info("GET BY ID TEST:");
		for (int i = 1; i <= 4; i++) {
			adr = dao.getElementById(i);
			LOGGER.info(adr);
		}

		adr.setCity("Dontsk").setHouse("3333");
		LOGGER.info("UPDATE TEST");
		dao.updateElement(adr);
		
		LOGGER.info("GET BY ID TEST:");
		for (int i = 1; i <= 4; i++) {
			adr = dao.getElementById(i);
			LOGGER.info(adr);
		}
		
		LOGGER.info("DELETE TEST");
		dao.deleteElementById(id);
		
		LOGGER.info("GET BY ID TEST:");
		for (int i = 1; i <= 4; i++) {
			adr = dao.getElementById(i);
			LOGGER.info(adr);
		}
	}
}
