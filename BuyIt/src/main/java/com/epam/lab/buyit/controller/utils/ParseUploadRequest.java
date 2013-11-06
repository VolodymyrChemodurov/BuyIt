package com.epam.lab.buyit.controller.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ParseUploadRequest {

	public static Map<String, String[]> getParametersMap(List<FileItem> items) {
		Map<String, String[]> inputMap = new HashMap<String, String[]>();
		for (FileItem item : items) {
			if (item.isFormField()) {
				String key = item.getFieldName();
				String[] values = new String[1];
				values[0] = item.getString();
				inputMap.put(key, values);
			}
		}
		return inputMap;
	}

	public static List<FileItem> getFileItems(List<FileItem> items) {
		List<FileItem> fileItems = new ArrayList<FileItem>();
		for (FileItem item : items) {
			if (!item.isFormField()) {
				fileItems.add(item);
			}
		}
		return fileItems;
	}

	public static List<FileItem> parseRequest(HttpServletRequest request) {
		List<FileItem> items = null;
		if (ServletFileUpload.isMultipartContent(request)) {
			ServletFileUpload upload = new ServletFileUpload(
					new DiskFileItemFactory());
			try {
				items = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		return items;
	}

}
