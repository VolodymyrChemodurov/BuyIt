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
import com.epam.lab.buyit.controller.setters.ProductSetter;
import com.epam.lab.buyit.model.Image;
import com.epam.lab.buyit.model.Product;

public class UserEditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ProductServiceImpl productService = new ProductServiceImpl();
		int id = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getItemById(id);
		request.setAttribute("currentProduct", product);
		request.getRequestDispatcher("userEditProductJsp").forward(request,
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

		Product product = productService.getItemById(idTemp);
		List<FileItem> fileItems = getFileItems(items);
		if (!fileItems.get(0).getName().isEmpty()) {
			product = ProductSetter.uploadingImages(product, fileItems);
		}
		product = ProductSetter.setDescriptionFields(product, inputValues);
		for (Image temp : list) {
			product.getDescription().setItemPhoto(temp);
		}
		productService.updateByProductId(product);
		response.sendRedirect("productDetails?id=" + product.getIdProduct());
	}

}
