package com.epam.lab.buyit.controller.service.search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.model.Product;

public class SearchServiceImpl implements SearchService {

	

	@Override
	public void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean hasFldPrms = false;
		boolean hasTxtPrms = false;

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
		
		List<Product> products = setProductDetailes(srchedPrdct);

		if (srchedPrdct != null) {

			request.setAttribute("srchedPrdct", products);
			request.setAttribute("aviliablePrdcts", srchedPrdct.size());
			RequestDispatcher view = request.getRequestDispatcher("/searching");
			view.forward(request, response);

		} else {
			searchError(request, response, "No product found");
		}
	}

	private List<Product> setProductDetailes(List<Product> srchedPrdct) {
		List<Product> tmpPrdct = new ArrayList<>();
		ProductServiceImpl productService = new ProductServiceImpl();
		for (Product aList : srchedPrdct) {
			tmpPrdct.add(productService.getItemById(aList.getIdProduct()));
		}
		return tmpPrdct;
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
