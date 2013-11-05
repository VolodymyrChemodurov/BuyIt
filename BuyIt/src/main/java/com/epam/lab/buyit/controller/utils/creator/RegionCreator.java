package com.epam.lab.buyit.controller.utils.creator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class RegionCreator {
	private static final Logger LOG = Logger.getLogger(RegionCreator.class);
	private static final String CONNECTION_PROPERTIES = "region.properties";
	private static Properties properties = null;

	private RegionCreator() {
		throw new UnsupportedOperationException("It's not possible to create util class instance");
	}

	private static void initialization() {
		properties = new Properties();
		try {
			ClassLoader cLoader = Thread.currentThread().getContextClassLoader();
			InputStream stream = cLoader.getResourceAsStream(CONNECTION_PROPERTIES);
			properties.load(stream);
			
		} catch (FileNotFoundException e) {
			LOG.error("Cannot found connection properties file", e);
			e.printStackTrace();
		} catch (IOException e) {
			LOG.error("Cannot load connection properties file", e);
			e.printStackTrace();
		}
	}

	public static String getRegion(String key){
		
		if (properties == null){
			initialization();
		}
		return properties.getProperty(key);
	}
	
	public static List<String> getRegionList(){
		List<String> resultList = new ArrayList<String>();
		for(Integer i=1; i<26; i++){
			resultList.add(getRegion(i.toString()));
		}
		
		return resultList;
	}
}
