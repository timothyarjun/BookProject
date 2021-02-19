package com.book.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.book.entity.Product;
import com.book.service.ProductService;
import com.book.utils.UploadFile;

@RestController
public class ImageController {
	private ProductService productService;	
	
	  @Autowired
	  public ImageController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@Value("${file.upload}")
      private String defaultFilePath;
      
    @RequestMapping("/product")
	public Product saveProduct(@RequestParam("data") String data, @RequestParam("imagepath") MultipartFile multipart) throws Exception{
    	if(multipart == null || multipart.getOriginalFilename() == null ) {
    		System.out.println("404 File not Found"); 
    	}
    	System.out.println(data);
    	Product p = UploadFile.convertStringToProduct(data);
    	//System.out.println(defaultFilePath);
    	UploadFile.uploadFile(multipart, p.getCategory(), p.getProductname(),defaultFilePath);
    	String staticpath = UploadFile.createStaticPath(p.getCategory(), p.getProductname(), multipart.getOriginalFilename());
    	System.out.println(staticpath);
    	p.setImagepath(staticpath);
    	productService.saveProduct(p);
    	return p;
    }
    
    @GetMapping("/{category}/{product}/{fileName:.+}")
    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response, @PathVariable("category") String category, @PathVariable("product") String product,@PathVariable("fileName") String fileName) {
    	File file = new File(UploadFile.createStaticURI(defaultFilePath,category,product,fileName));
    	
    	if(file.exists()) {
//    		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//    		System.out.println(mimeType + "this is mimetype");
//    		if(mimeType == null)
//    			mimeType = "application/octet-stream";
//    		
//    		response.setContentType(mimeType);
//    		response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
//    		response.setContentLength((int) file.length());
    		
    		InputStream inputStream;
    		try {
				inputStream = new BufferedInputStream(new FileInputStream(file));
				FileCopyUtils.copy(inputStream, response.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}    		
    	}    		
    }
    
    @PostMapping("/rigisterproduct")
    public Product saveProduct(@RequestBody Product product) {
    	return productService.saveProduct(product);
    }
    
    @GetMapping("findone/{id}")
    public Product findOne(@PathVariable("id") long id) {
    	return productService.findOne(id);
    }
    
//    @PostMapping("/uploadprofile")
//    public void uploadPic(@RequestParam("file") MultipartFile multipart, @RequestParam("id") long id) {
//    	productService.uploadpic(multipart,id);
//    }
    
    @GetMapping("/{id}")
    public void imageReader(HttpServletResponse res,@PathVariable int id) {
    	Product p= productService.findOne(id);
//    	File file = new File(p.getImagepath());
//    	byte[] bytes = null;
//    	if(file.exists()) {
//    		bytes =p.getImagepath().getBytes();
//    		return ResponseEntity.ok().body(bytes);
//    	}
//		return null;
    	
    	File f = new File(p.getImagepath());
    	if(f.exists()) {
    		res.setContentType("image/jpeg");

    		byte[] b = p.getImagepath().getBytes();
    		
    		try {
    			//InputStream inputStream = new BufferedInputStream(new FileInputStream(f));
    			InputStream inputStream = new ByteArrayInputStream(b);
				FileCopyUtils.copy(inputStream, res.getOutputStream());
				} catch (Exception e) {
				e.printStackTrace();
			}
    	}
    		
    }
      
}
