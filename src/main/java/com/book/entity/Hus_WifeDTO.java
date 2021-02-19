package com.book.entity;

public class Hus_WifeDTO {
	private long id;
	private String hus_name;
	private String wife_name;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getHus_name() {
		return hus_name;
	}
	public void setHus_name(String hus_name) {
		this.hus_name = hus_name;
	}
	public String getWife_name() {
		return wife_name;
	}
	public void setWife_name(String wife_name) {
		this.wife_name = wife_name;
	}
	@Override
	public String toString() {
		return "Hus_WifeDTO [id=" + id + ", hus_name=" + hus_name + ", wife_name=" + wife_name + "]";
	}
	
	
}
