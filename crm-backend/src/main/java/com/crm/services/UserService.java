package com.crm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.models.User;
import com.crm.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository Repository;
	
	public Boolean logIn(User x) {
		Boolean bool = false;
		return bool;
	}
}
