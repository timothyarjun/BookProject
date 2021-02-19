package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.Address;
import com.book.service.AddressService;

@RestController
@RequestMapping("/add/api")
public class AddressController {
	private AddressService address_service;

	@Autowired
	public AddressController(AddressService address_service) {
		this.address_service = address_service;
	}

	@RequestMapping("/add")
	public ResponseEntity<String> addAddress(@RequestBody Address address) {
		return new ResponseEntity<>(address_service.addAddress(address).toString(),HttpStatus.OK);
	}
	
}
