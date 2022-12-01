package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.models.User;
import com.crm.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
    private UserService service;
	
	@PostMapping
    public ResponseEntity<User> logIn(@RequestBody User x) {
		Boolean res;
		res=service.logIn(x);
		if(res) {
			return new ResponseEntity<>(x, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(x, HttpStatus.NOT_FOUND); }
    }
	
	@GetMapping
    public List<User> listUsers() {
        return service.getUsers();
    }
}
