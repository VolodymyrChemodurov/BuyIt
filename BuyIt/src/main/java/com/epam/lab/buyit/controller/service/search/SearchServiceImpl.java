package com.epam.lab.buyit.controller.service.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.dao.product.ProductDAO;
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
		if (srchedPrdct != null) {
			request.setAttribute("srchedPrdct", srchedPrdct);
			RequestDispatcher view = request
					.getRequestDispatcher("/searching");
			/* результати пошуку */
			view.forward(request, response);

		} else {
			searchError(request, response, "No product found");
		}
	}

	private void searchByName(HttpServletRequest request,
			HttpServletResponse response, String srchedFld)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		List<Product> srchedPrdct = dao.findElementByName(srchedFld);
		if (srchedPrdct != null) {
			request.setAttribute("srchedPrdct", srchedPrdct);
			RequestDispatcher view = request
					.getRequestDispatcher("/searching");
			/* результати пошуку */
			view.forward(request, response);

		} else {
			searchError(request, response, "No product found");
		}
	}

	private void searchByCategory(HttpServletRequest request,
			HttpServletResponse response, String srchedTxt)
			throws ServletException, IOException {
		ProductDAO dao = new ProductDAO();
		List<Product> srchedPrdct = dao.findElementByCategory(srchedTxt);

		if (srchedPrdct != null) {

			request.setAttribute("srchedPrdct", srchedPrdct);
			RequestDispatcher view = request
					.getRequestDispatcher("/searching");
			/* результати пошуку */
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
