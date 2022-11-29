package com.crm.services.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.crm.models.User;
import com.crm.repositories.UserRepository;
import com.crm.services.UserService;

@SpringBootTest
public class UserSeviceTest {
	
	@Autowired
	UserService userService;
	@Autowired
	UserRepository userRepository;
	//Login Test, the user must Log in and get the logged token
	@Test
	public void logInTest(){
		User x = new User(1, "prueba1", "prueba1");
		userRepository.setUp();
		Boolean y = null;
		y=userService.logIn(x);
		Assert.isTrue(y);
	}
	//Login Test, the user must NOT Log in, as it doesn't have password
	@Test
	public void logInErrorTest(){
		User x = new User(1, "prueba1", "");
		userRepository.setUp();
		Boolean y = null;
		y=userService.logIn(x);
		Assert.isTrue(!y);
	}
}
