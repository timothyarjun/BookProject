package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.Address;
import com.book.repository.AddressRepo;
import com.book.repository.UserRepo;

@Service
public class AddressService {
	private AddressRepo addressrepo;
	private UserRepo userRepo;
	
	@Autowired
	public AddressService(AddressRepo addressrepo, UserRepo userRepo) {
		this.addressrepo = addressrepo;
		this.userRepo = userRepo;
	}	
	
	public Address addAddress(Address address) {
		address.setUser(userRepo.getOne(address.getUserId()));
		return addressrepo.save(address);
	}
}
