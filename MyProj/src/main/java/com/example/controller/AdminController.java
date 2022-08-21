package com.example.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Admin;
import com.example.service.IAdminService;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {

	@Autowired
	IAdminService service;

	@PostMapping("/login")
	public boolean loginAdmin(@RequestBody Admin admin) {
		service.login(admin);
		if(service.login(admin)==true) {
			return true;
		}
		else {
			return false;
		}
	}

	@PostMapping("/register")
	public boolean regitserAdmin(@RequestBody Admin admin) {
		System.out.println("admin = " + admin);
		return service.register(admin);
	}

	
}
