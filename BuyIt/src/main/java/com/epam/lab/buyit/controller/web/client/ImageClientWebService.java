package com.epam.lab.buyit.controller.web.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.epam.lab.buyit.controller.web.service.UserWebService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;

public class ImageClientWebService {

	private static final Logger LOGGER = Logger
			.getLogger(ImageClientWebService.class);

	private static URI baseUri;
	private ClientConfig config;
	private Client client;
	private WebResource service;

	private static String EMAIL, PASSWORD;
	private static final String propFilePath = "web-services.properties";

	public ImageClientWebService() {
		config = new DefaultClientConfig();
		client = Client.create(config);
		service = client.resource(baseUri);
	}

	static {
		baseUri = UriBuilder.fromUri("http://localhost:8080/dreamhost/host/")
				.build();
		Properties prop = new Properties();
		LOGGER.info("Loading web-client properties...");
		try {
			prop.load(UserWebService.class.getClassLoader()
					.getResourceAsStream(propFilePath));
			EMAIL = prop.getProperty("host.email");
			PASSWORD = prop.getProperty("host.password");
			LOGGER.info("Web-client properties loading complete.");
		} catch (IOException e) {
			LOGGER.error(e);
			EMAIL = PASSWORD = "";
		}
	}

	public List<String> createImages(List<FileItem> images, String token)
			throws IOException {

		JSONObject object = new JSONObject();
		List<String> result = new ArrayList<String>();
		try {
			FormDataMultiPart form = setParams(images);
			ClientResponse resp = service.path("files").path("upload")
					.path("0").path(token).type(MediaType.MULTIPART_FORM_DATA)
					.post(ClientResponse.class, form);
			JSONArray jsonArray = resp.getEntity(JSONArray.class);
			for (int i = 0; i < jsonArray.length(); i++) {
				object = jsonArray.getJSONObject(i);
				result.add(object.getString("url"));
			}
		} catch (JSONException e) {
			LOGGER.error(e);
		}
		return result;
	}

	public String createToken(long liveTime) {
		JSONObject tokenData = new JSONObject();
		try {
			tokenData.put("liveTime", liveTime);
		} catch (JSONException e) {
			e.printStackTrace();
		}

		JSONObject outputJsonObject = service.path("token").path("create")
				.path(EMAIL).path(PASSWORD).accept(MediaType.APPLICATION_JSON)
				.post(JSONObject.class, tokenData);
		String token = null;
		try {
			token = (String) outputJsonObject.get("token");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return token;
	}

	public List<FileItem> getFileItems(HttpServletRequest request) {
		List<FileItem> items = null;
		ServletFileUpload upload = null;
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				upload = new ServletFileUpload(new DiskFileItemFactory());
				items = upload.parseRequest((RequestContext) request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

	private FormDataMultiPart setParams(List<FileItem> items)
			throws IOException {
		FormDataMultiPart form = new FormDataMultiPart();
		for (FileItem item : items) {
			InputStream inputStream = item.getInputStream();
			FormDataBodyPart bodyPart = new FormDataBodyPart("file",
					inputStream, MediaType.APPLICATION_OCTET_STREAM_TYPE);
			FormDataContentDisposition cd = FormDataContentDisposition
					.name("file").fileName(item.getName()).build();
			bodyPart.setFormDataContentDisposition(cd);
			form.bodyPart(bodyPart);
		}
		return form;
	}

}
