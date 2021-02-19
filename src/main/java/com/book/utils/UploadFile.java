package com.book.utils;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.entity.Product;
import com.google.gson.Gson;

public class UploadFile {

	public static Product convertStringToProduct(String ProductString) {
		Product p = null;
		try {
			Gson g= new Gson();
			p=g.fromJson(ProductString, Product.class);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public static String uploadFile(MultipartFile file, String category, String productname,String defaultFilePath) throws Exception {
			String filepath= "";
			System.out.println(file);
			if(file.isEmpty())
				throw new Exception("Error while saving file");
			
			try {
				String message = createFile(defaultFilePath, category, productname);
				if(!StringUtils.isEmpty(message) && message.equalsIgnoreCase("Folder Created Successfully") || StringUtils.isEmpty(message)) {
					byte[] bytes = file.getBytes(); 
					if(file.getOriginalFilename()!=null)
						filepath = defaultFilePath + "/" + 	category + "/" + productname + "/" + file.getOriginalFilename();
					//System.out.println(filepath);
					Path paths = Paths.get(filepath);
					Files.write(paths, bytes);
					System.out.println(paths);
				}
				else {
					throw new Exception("Error while saving file");
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
			return filepath;
	}

	private static String createFile(String folderpath, String category, String productname) {
		String message = "";
		File Folder = new File(folderpath + "/" + category);
		if(!Folder.exists()) {
			if(Folder.mkdir())
				message = "Folder Created Successfully";
			else
				message = "Folder Already Created";			
		}
		
		File file = new File(folderpath + "/" + category + "/" + productname);
		if(!file.exists()) {
			if(file.mkdir())
				message = "Folder Created Successfully";
			else
				message = "Folder Already Created";	
		}		
		return message;
	}

	public static String createStaticPath(String category, String productname, String filename) {
		return ServletUriComponentsBuilder.fromCurrentContextPath().path(category + "/" + productname + "/" + filename).toUriString();
	}

	public static String createStaticURI(String defaultFilePath, String category, String product, String fileName) {
		return defaultFilePath+"/"+category+"/"+product+"/"+fileName;
	}

	public static void putAsset(String filepath, InputStream inputstream, String string) {
		
	}
	
}
