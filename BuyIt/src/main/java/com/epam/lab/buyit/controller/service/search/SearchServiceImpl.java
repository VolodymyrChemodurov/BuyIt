package com.epam.lab.buyit.controller.service.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.dao.auction.AuctionDAO;
import com.epam.lab.buyit.controller.dao.description.DescriptionDAO;
import com.epam.lab.buyit.controller.dao.image.ImageDAO;
import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.model.Auction;
import com.epam.lab.buyit.model.Description;
import com.epam.lab.buyit.model.Image;
import com.epam.lab.buyit.model.Product;

public class SearchServiceImpl implements SearchService {

	private boolean hasFldPrms = false;
	private boolean hasTxtPrms = false;

	@Override
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String srchedFld = request.getParameter("srchedFld");
		String srchedTxt = request.getParameter("srchedTxt");

		if ((srchedFld != null)
				&& ((srchedFld = srchedFld.trim()).length() > 0)) {
			hasFldPrms = true;
		}
		if ((srchedTxt != null) && (!srchedTxt.equals("Select..."))) {
			hasTxtPrms = true;
		}
		if (!hasFldPrms && !hasTxtPrms) {
			searchError(request, response, "Put search query");
		} else {

			if (!hasFldPrms && hasTxtPrms) {

				searchByCategory(request, response, srchedTxt);

			} else if (hasFldPrms && !hasTxtPrms) {

				searchByName(request, response, srchedFld);

			} else if (hasFldPrms && hasTxtPrms) {

				searchByNameCategory(request, response, srchedFld, srchedTxt);

			}

		}

	}

	private void searchByNameCategory(HttpServletRequest request,
			HttpServletResponse response, String srchedFld, String srchedTxt)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();

		List<Product> srchedPrdct = dao.findElementByNameCategory(srchedFld,
				srchedTxt);
		forwardToJsp(request, response, srchedPrdct);
	}

	private void searchByName(HttpServletRequest request,
			HttpServletResponse response, String srchedFld)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();

		List<Product> srchedPrdct = dao.findElementByName(srchedFld);
		forwardToJsp(request, response, srchedPrdct);
	}

	private void searchByCategory(HttpServletRequest request,
			HttpServletResponse response, String srchedTxt)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();

		List<Product> srchedPrdct = dao.findElementByCategory(srchedTxt);
		forwardToJsp(request, response, srchedPrdct);
	}

	private void forwardToJsp(HttpServletRequest request,
			HttpServletResponse response, List<Product> srchedPrdct)
			throws ServletException, IOException {
		List<Auction> buyingDetails = getPrice(srchedPrdct);
		List<Description> description = getDesription(srchedPrdct);
		List<Image> images = getImages(description);

		if (srchedPrdct != null) {

			request.setAttribute("srchedPrdct", srchedPrdct);
			request.setAttribute("buyingDetails", buyingDetails);
			request.setAttribute("description", description);
			request.setAttribute("images", images);
			request.setAttribute("aviliablePrdcts", srchedPrdct.size());
			RequestDispatcher view = request.getRequestDispatcher("/searching");
			view.forward(request, response);

		} else {
			searchError(request, response, "No product found");
		}
	}

	private void searchError(HttpServletRequest request,
			HttpServletResponse response, String errorMsg)
			throws ServletException, IOException {
		request.setAttribute("ErrorMSG", errorMsg);
		RequestDispatcher view = request.getRequestDispatcher("/homePage");
		view.forward(request, response);
	}

	private List<Auction> getPrice(List<Product> srchedPrdct) {
		AuctionDAO auctionDAO = new AuctionDAO();
		List<Auction> buyingDetails = new ArrayList<>();
		for (Product aList : srchedPrdct) {
			buyingDetails
					.add(auctionDAO.getByProductId(aList.getIdProduct()));
		}
		return buyingDetails;
	}

	private List<Description> getDesription(List<Product> srchedPrdct) {
		DescriptionDAO descriptionDAO = new DescriptionDAO();
		List<Description> description = new ArrayList<>();
		for (Product aList : srchedPrdct) {
			description
					.add(descriptionDAO.getElementById(aList.getIdProduct()));
		}
		return description;
	}
	
	private List<Image> getImages(List<Description> description) {
		ImageDAO imageDAO = new ImageDAO();
		List<Image> images = new ArrayList<>();
		for (Description aList : description) {
			images.add(imageDAO.getElementById(aList.getIdDescription()));
		}
		return images;
	}

	@Override
	public Product getItemById(int id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Product> getAllItems() {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product createItem(Product item) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Product updateItem(Product item) {
		throw new UnsupportedOperationException();
	}

}
