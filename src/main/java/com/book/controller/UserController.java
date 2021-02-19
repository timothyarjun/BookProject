package com.book.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.service.UserService;

@RestController
@RequestMapping("/user/api")
public class UserController {
	
	private UserService userservice;
}
