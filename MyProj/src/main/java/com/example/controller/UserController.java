package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.service.IUserService;


@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	IUserService service;
	
	

	@PostMapping("/login")
	public boolean loginUser(@RequestBody User user) {
		System.out.println("user = " + user);
		service.login(user);
		if(service.login(user)==true) {
			return true;
		}
		else {
			return false;
		}
	}

	@PostMapping("/register")
	public boolean regitserUser(@RequestBody User user) {
		System.out.println("user = " + user);
		return service.register(user);
	}

	
}
