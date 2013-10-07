package com.epam.lab.buyit.controller.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.lab.buyit.controller.dao.product.ProductDAO;
import com.epam.lab.buyit.controller.web.Mook;
import com.epam.lab.buyit.model.Product;

/**
 * Servlet implementation class SearchServlet
 */
// @WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String srchedFld = request.getParameter("srchedFld");
		String srchedTxt = request.getParameter("srchedTxt");
		boolean hasFldPrms = false;
		boolean hasTxtPrms = false;
		if ((srchedFld != null) && ((srchedFld = srchedFld.trim()).length() > 0)) {
			hasFldPrms = true;
		}
		if ((srchedTxt != null) && (!srchedTxt.equals("Select..."))) {
			hasTxtPrms = true;
		}
		if (!hasFldPrms && !hasTxtPrms) {
			request.setAttribute("ErrorMSG", "Put search query");
			RequestDispatcher view = getServletContext().getRequestDispatcher(
					"/homePage.jsp");
			view.forward(request, response);
			/* відправляти повідомлення типу "Задайте поисковый запрос." */

		} else {

			if (!hasFldPrms && hasTxtPrms) {

				// ProductDAO dao = new ProductDAO();
				// List<Product> srchedPrdct =
				// dao.findElementByCategory(srchedFld);

				Map<String, List<String>> productList = Mook.getProducts();
				if (productList.containsKey(srchedTxt)) {

					List<String> srchedPrdct = productList.get(srchedTxt);
					request.setAttribute("srchedPrdct", srchedPrdct);
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/searchResult.jsp");
					/* результати пошуку */
					view.forward(request, response);

				} else {
					request.setAttribute("ErrorMSG", "No product found");
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/homePage.jsp");
					view.forward(request, response);
				}

			} else if (hasFldPrms && !hasTxtPrms) {

				ProductDAO dao = new ProductDAO();
				List<Product> srchedPrdct = dao.findElementByName(srchedFld);
				if (srchedPrdct != null) {
					request.setAttribute("srchedPrdct", srchedPrdct);
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/searchResult.jsp");
					/* результати пошуку */
					view.forward(request, response);

				} else {
					request.setAttribute("ErrorMSG", "No product found");
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/homePage.jsp");
					view.forward(request, response);
				}

			} else if (hasFldPrms && hasTxtPrms) {

				ProductDAO dao = new ProductDAO();
				List<Product> srchedPrdct = dao.findElementByNameCategory(
						srchedFld, srchedFld);
				if (srchedPrdct != null) {
					request.setAttribute("srchedPrdct", srchedPrdct);
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/searchResult.jsp");
					/* результати пошуку */
					view.forward(request, response);

				} else {
					request.setAttribute("ErrorMSG", "No product found");
					RequestDispatcher view = getServletContext()
							.getRequestDispatcher("/homePage.jsp");
					view.forward(request, response);
				}

			} else {
				request.setAttribute("ErrorMSG", "No product found");
				RequestDispatcher view = getServletContext()
						.getRequestDispatcher("/homePage.jsp");
				view.forward(request, response);
			}
		}

	}
}
