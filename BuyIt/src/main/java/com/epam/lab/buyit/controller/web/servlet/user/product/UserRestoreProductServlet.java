package com.epam.lab.buyit.controller.web.servlet.user.product;

import static com.epam.lab.buyit.controller.utils.ParseRequest.getFileItems;
import static com.epam.lab.buyit.controller.utils.ParseRequest.getParametersMap;
import static com.epam.lab.buyit.controller.utils.ParseRequest.parseRequest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;

import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.utils.creator.ProductCreator;
import com.epam.lab.buyit.controller.utils.setters.ProductSetter;
import com.epam.lab.buyit.controller.utils.validator.ProductValidation;
import com.epam.lab.buyit.model.Image;
import com.epam.lab.buyit.model.Product;

public class UserRestoreProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		int id = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getItemById(id);
		request.setAttribute("currentProduct", product);
		request.getRequestDispatcher("userRestoreProductJsp").forward(request,
				response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		request.setCharacterEncoding("utf-8");
		List<FileItem> items = parseRequest(request);
		Map<String, String[]> inputValues = getParametersMap(items);
		int idTemp = Integer.parseInt(inputValues.get("productId")[0]);
		List<Image> list = productService.getItemById(idTemp).getDescription()
				.getItemPhotos();
		if (ProductValidation.checkingInputValues(inputValues)) {
			Product product = new ProductCreator().create(inputValues);
			List<FileItem> fileItems = getFileItems(items);
			product = ProductSetter.uploadingImages(product, fileItems);
			for (Image temp : list) {
				product.getDescription().setItemPhoto(temp);
			}
			int id = productService.createItem(product).getIdProduct();
			response.sendRedirect("productDetails?id=" + id);
		} else {
			response.sendRedirect("userRestoreProduct?productId="
					+ inputValues.get("productId")[0]);
		}
	}
}
