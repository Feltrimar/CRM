package com.crm.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.models.User;

@Repository
public class UserRepository {
    private List<User> list = start();
    
    
    
    public List<User> start() {
    	List<User> list = new ArrayList<User>();
    	User x = new User("user", "password");
        list.add(x);
		return list;
        }
    
    public void setUp() {
    	User x = new User("prueba1", "prueba1");
        list.add(x);
        }
        
        
    public List<User> getAllUsers() {
        return list;
    }

}