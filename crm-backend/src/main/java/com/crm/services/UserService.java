package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.models.User;
import com.crm.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public Boolean logIn(User x) {
		Boolean bool = false;
		List<User> aux=getUsers();
		System.out.println(repository.getAllUsers());		
		for(User u: aux) {
			if(u.getUserName().equals(x.getUserName())) {
				if(u.getPassword().equals(x.getPassword())) {
					bool = true;
					break;
				}
			}
		}
		return bool;
	}
	
	public List<User> getUsers() {
        return repository.getAllUsers();
    }
	
	
}
