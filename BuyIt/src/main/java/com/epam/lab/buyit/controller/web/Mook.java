package com.epam.lab.buyit.controller.web;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Mook {

	public static Map<String,List<String>> getProducts(){
		Map<String,List<String>> result =  new LinkedHashMap<>();
		List<String> phones = new ArrayList<>();
		List<String> pcs = new ArrayList<>();
		List<String> tvs = new ArrayList<>();
		List<String> electronics = new ArrayList<>();
		phones.add("htc");
		phones.add("samsung");
		phones.add("nokia");
		phones.add("sony-ericson");
		
		pcs.add("Intel");
		pcs.add("AMD");
		pcs.add("MAC");
		
		tvs.add("Thomson");
		tvs.add("LG");
		tvs.add("Samsung");
		tvs.add("Orion");
		
		electronics.add("some branch");
		
		
		
		
		result.put("Phones", phones);
		result.put("PCs", pcs);
		result.put("TVs", tvs);
		result.put("Electronics", electronics);
		
		return result;
	}

	public static List<String> getImagesUrl() {
		List<String> result =  new ArrayList<String>();
		result.add("themes/images/carousel/2.png");
		result.add("themes/images/carousel/3.png");
		result.add("themes/images/carousel/4.png");
		result.add("themes/images/carousel/5.png");
		result.add("themes/images/carousel/6.png");
		result.add("themes/images/carousel/7.png");
		
		return result;
	}
	
	public static boolean authentication(String login, String password){
		boolean result = false;
		if (login.equals("admin") && password.equals("admin")){
			result = true;
		}
		return result;
	}
}
