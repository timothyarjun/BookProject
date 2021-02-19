package com.book.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;
@Entity
public class Address extends AbstractPersistable<Long> {
	private String city;
	private String state;
	private String country;
	// we will create one transient field for userId
	private transient long userId;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", country=" + country + ", user=" + user + ", getCity()="
				+ getCity() + ", getState()=" + getState() + ", getCountry()=" + getCountry() + ", getUser()="
				+ getUser() + ", getUserId()=" + getUserId() + "]";
	}	
	
		
}
