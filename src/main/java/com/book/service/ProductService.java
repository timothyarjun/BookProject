package com.book.service;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.book.entity.Product;
import com.book.repository.ProductRepo;
import com.book.utils.UploadFile;

@Service
public class ProductService {
	private ProductRepo productrepo;
	
	@Autowired
	public ProductService(ProductRepo productrepo) {
		super();
		this.productrepo = productrepo;
	}

	public Product saveProduct(Product product) {
		return productrepo.save(product);
	}

	public Product findOne(long id) {
		return productrepo.getOne(id);
	}

//	public String uploadpic(MultipartFile multipart, long id) {
//		try {
//			InputStream inputstream = new ByteArrayInputStream(multipart.getBytes());
//			String filepath = "testupload/" + id +"/"+ multipart.getOriginalFilename();
//			UploadFile.putAsset(filepath, inputstream, "image/jpeg");	
//			Product p = productrepo.getOne(id);
//			p.setImagepath(filepath);
//			return "success";
//			
//		} catch (Exception e) {
//			return "error";
//		}	
//	}
	
	
}
