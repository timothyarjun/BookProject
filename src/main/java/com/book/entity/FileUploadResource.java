package com.book.entity;

public class FileUploadResource {
	
    private String fileName;
    private String url;
    private String contentType;
    
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public FileUploadResource(String fileName, String url, String contentType) {
		super();
		this.fileName = fileName;
		this.url = url;
		this.contentType = contentType;
	}
	
	@Override
	public String toString() {
		return "FileUploadResource [fileName=" + fileName + ", url=" + url + ", contentType=" + contentType + "]";
	}
	
}
