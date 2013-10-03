package com.epam.lab.controller;

import java.util.ArrayList;
import java.util.List;

public class Mook {

	public static List<String> getProducts(){
		List<String> result =  new ArrayList<String>();
		result.add("Phones");
		result.add("PCs");
		result.add("TVs");
		result.add("Electronics");
		
		
		return result;
	}

	public static List<String> getImagesUrl() {
		List<String> result =  new ArrayList<String>();
		result.add("themes/images/carousel/1.png");
		result.add("themes/images/carousel/2.png");
		result.add("themes/images/carousel/3.png");
		result.add("themes/images/carousel/4.png");
		result.add("themes/images/carousel/5.png");
		result.add("themes/images/carousel/6.png");
		result.add("themes/images/carousel/7.png");
		
		return result;
	}
}
