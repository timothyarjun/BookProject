package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trainer extends Audit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;	
	
	private String subject;
	
	private double salary;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Trainer [id=" + id + ", subject=" + subject + ", salary=" + salary + ", getId()=" + getId()
				+ ", getSubject()=" + getSubject() + ", getSalary()=" + getSalary() + "]";
	}	
	
}
