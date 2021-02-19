package com.book.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.entity.FileUploadResource;
import com.book.service.FileStorageService;

@RestController
public class FileUploadController {
	private FileStorageService fileStorageService;
	
	@Autowired
	public FileUploadController(FileStorageService fileStorageService) {
		super();
		this.fileStorageService = fileStorageService;
	}
	
	@PostMapping("single/upload")
	public FileUploadResource singleFileUpload(@RequestParam MultipartFile file) {
		String fileName = fileStorageService.storeFile(file);
		
		String url = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(fileName)
				.toUriString();	
		
		String ContextType = file.getContentType();
		
		System.out.println(url + "----" + ContextType);
		
		FileUploadResource resource = new FileUploadResource(fileName, url, ContextType);
		return resource;
	}
	

	@GetMapping("/download/{fileName}")
	ResponseEntity<Resource> downloadSingleFile(@PathVariable String fileName, HttpServletRequest request){
		String mimeType;
		Resource resource = fileStorageService.downloadFile(fileName);
		try {
			mimeType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException e) {
			mimeType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}
		
//		MediaType contentType = MediaType.IMAGE_JPEG;
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(mimeType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "inline:fileName = "+ resource.getFilename())
				.body(resource);
	}
	
	@PostMapping("/multiple/upload")
	public List<FileUploadResource> multipleUpload(@RequestParam("files") MultipartFile[] files){
		if(files.length > 6)
			throw new RuntimeException("Too many Files........");
		
		List<FileUploadResource> uploadResponseList = new ArrayList<FileUploadResource>();
		 Arrays.asList(files)
		 .stream()
		 .forEach(file -> { String fileName = fileStorageService.storeFile(file);
			 String url = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/")
					 .path(fileName).toUriString();
			 
			 String contextType = file.getContentType();
			 FileUploadResource resource = new FileUploadResource(fileName, url, contextType);
			 uploadResponseList.add(resource);			 
		 });
		return uploadResponseList;
	}
	
	@GetMapping("/zipDownload")
	void zipDownload(@RequestParam("fileName") String[] files, HttpServletResponse response) throws IOException {
		try(ZipOutputStream zos=new ZipOutputStream(response.getOutputStream())){
			Arrays.asList(files)
			.stream()
			.forEach(file ->{
				Resource resource = fileStorageService.downloadFile(file);
				ZipEntry zipEntry = new ZipEntry(resource.getFilename());
				
				try {
					zipEntry.setSize(resource.contentLength());
					zos.putNextEntry(zipEntry);
					StreamUtils.copy(resource.getInputStream(), zos);
					zos.closeEntry();
				} catch (IOException e) {
					System.out.println("Some exception while ziping");
				}
			});
			zos.finish();
			response.setStatus(200);
			response.addHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment:fileName = zipfile");
		}		
	}
}
