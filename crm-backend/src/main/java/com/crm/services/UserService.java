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
		for(User u: aux) {
			System.out.println(x);
			System.out.println(u.getUserName()+ " " +u.getPassword()+" , "+x.getUserName() + " " + x.getPassword());
			if(u.getUserName().equals(x.getUserName())) {
				System.out.println("a");
				if(u.getPassword().equals(x.getPassword())) {
					System.out.println("b");
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
