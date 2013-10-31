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

import com.epam.lab.buyit.controller.creator.ProductCreator;
import com.epam.lab.buyit.controller.service.product.ProductServiceImpl;
import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.controller.validator.ProductValidation;
import com.epam.lab.buyit.model.Product;

public class UserAddProductServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("userAddProduct");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ProductServiceImpl productService = new ProductServiceImpl();
		request.setCharacterEncoding("utf-8");
		List<FileItem> items = parseRequest(request);
		Map<String, String[]> inputValues = getParametersMap(items);
		if (ProductValidation.checkingInputValues(inputValues)) {
			Product product = new ProductCreator().create(inputValues);
			List<FileItem> fileItems = getFileItems(items);
			product = ProductSetter.uploadingImages(product, fileItems);
			int id = productService.createItem(product).getIdProduct();
			response.sendRedirect("productDetails?id=" + id);
		} else {
			response.sendRedirect("userAddProduct");
		}
	}

	
}
