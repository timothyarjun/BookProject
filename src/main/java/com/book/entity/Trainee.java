package com.book.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Trainee extends Audit{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private double fee;
	
	private String grade;	
	
	@Column(name = "Admision_Date")
	@JsonFormat(pattern = "dd-MM-yyyy")     // format the Input date 
	private Date date;
	
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double fee) {
		this.fee = fee;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Trainee [id=" + id + ", fee=" + fee + ", grade=" + grade + ", date=" + date + ", getDate()=" + getDate()
				+ ", getId()=" + getId() + ", getFee()=" + getFee() + ", getGrade()=" + getGrade() + "]";
	}
	
	
}
