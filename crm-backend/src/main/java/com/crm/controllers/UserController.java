package com.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.models.User;
import com.crm.services.UserService;

@RestController
@RequestMapping("/api/v1/login")
public class UserController {
	
	@Autowired
    private UserService service;
	
	@PostMapping
    public Boolean logIn(@RequestBody User x) {
        return service.logIn(x);
    }

}
