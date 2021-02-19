package com.book.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass	//  super class indication
@EntityListeners(AuditingEntityListener.class)	   //mapped other class
public class Audit {
	
	private String name;
	
	private String password;
	
	private String age;	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Audit [name=" + name + ", age=" + age + "]";
	}	
		
}
