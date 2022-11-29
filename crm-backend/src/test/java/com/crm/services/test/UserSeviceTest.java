package com.crm.services.test;


import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import com.crm.models.User;
import com.crm.services.UserService;

public class UserSeviceTest {
	
	UserService userService;
	//Login Test, the user must Log in and get the logged token
	@Test
	public void logInTest(){
		User x = new User(1, "prueba1", "prueba1");
		Boolean y = false;
		y=userService.logIn(x);
		Assert.isTrue(y);
	}
	//Login Test, the user must NOT Log in, as it doesn't have password
	public void logInErrorTest(){
		User x = new User(1, "prueba1", "");
		Boolean y = false;
		y=userService.logIn(x);
		Assert.isTrue(!y);
	}
}
