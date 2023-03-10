package com.multiplex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiplex.entities.Admin;
import com.multiplex.exception.InvalidAdminException;
import com.multiplex.services.AdminServices;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServices adminServices;
	@PostMapping("/adminRegistration")
	public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
		Admin f=this.adminServices.registerAdmin(admin);
		return new ResponseEntity<>(f, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<String> loginAdmin(@RequestBody Admin admin) {
	    try {
	        String result = this.adminServices.loginAdmin(admin);
	        return ResponseEntity.ok(result);
	    } catch (InvalidAdminException e) {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid admin");
	    }
	}


}
