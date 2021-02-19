package com.book.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Wife implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1009887182048106148L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	// one to one mapping 
	@JsonManagedReference
	@OneToOne(fetch = FetchType.EAGER,optional = false,mappedBy = "wife")
	private Husband husband;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Husband getHusband() {
		return husband;
	}

	public void setHusband(Husband husband) {
		this.husband = husband;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Wife(long id, String name, int age, Husband husband) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.husband = husband;
	}

	public Wife() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
