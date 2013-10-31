package com.epam.lab.buyit.controller.utils;

import java.io.IOException;
import java.net.URI;
import java.util.Properties;

import javax.ws.rs.core.UriBuilder;

import org.apache.log4j.Logger;

import com.epam.lab.buyit.controller.web.client.MessageClientWebService;

public class WebServicesPropertiesGetter {
	private static final Logger LOGGER = Logger.getLogger(MessageClientWebService.class);
	private static final String propFilePath = "web-services.properties";
	private static URI forumServiceURI;
	private static String forumClientLogin;
	private static String forumClientPassword;
	
	static {
			Properties prop = new Properties();
			try {
				LOGGER.info("Loading web-services properties...");
				prop.load(WebServicesPropertiesGetter.class.getClassLoader().getResourceAsStream(propFilePath));
				String url = prop.getProperty("forum.service.url");
				forumClientLogin = prop.getProperty("user.login");
				forumClientPassword = prop.getProperty("user.password");
				forumServiceURI = UriBuilder.fromUri(url).build();
				LOGGER.info("Web-services properties loading complete.");
			} catch (IOException e) {
				LOGGER.error(e);
				forumClientLogin = forumClientPassword = "";
				forumServiceURI  = UriBuilder.fromUri("http://localhost:8080/memorium/buyIt/").build();
			}
	}

	public static URI getForumBaseURI() {
		return forumServiceURI;
	}
	
	public static String getForumClientLogin() {
		return forumClientLogin;
	}
	
	public static String getForumClientPassword() {
		return forumClientPassword;
	}
}
