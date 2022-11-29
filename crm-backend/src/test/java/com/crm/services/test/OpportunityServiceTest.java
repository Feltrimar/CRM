package com.crm.services.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.crm.models.Opportunity;
import com.crm.repositories.OpportunityRepository;
import com.crm.repositories.UserRepository;
import com.crm.services.OpportunityService;
import com.crm.services.UserService;

@SpringBootTest
public class OpportunityServiceTest {

	@Autowired
	OpportunityService opportunityService;
	@Autowired
	OpportunityRepository opportunityRepository;
	
	//Testing trying to create a new Opportunity
	@Test
	public void testCreateOpportunity(){
		Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		Boolean y = false;
		y=opportunityService.createOpportunity(x);
		Assert.isTrue(y);
	}
	
	//Testing trying to create directly a opportunity with the same parameters IT MUST SEND ERROR
	@Test
	public void testErrorCreateDuplicatedOpportunity(){
		Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		opportunityRepository.setUp();
		Boolean y = false;
		y=opportunityService.createOpportunity(x);
		Assert.isTrue(!y);
	}
	
	//Testing trying to create directly a customer from a Opportunity IT MUST SEND ERROR
	@Test
	public void testErrorCreateCustomer(){
		Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		x.setCustomer(true);
		Boolean y = false;
		y=opportunityService.createOpportunity(x);
		Assert.isTrue(!y);
	}
}
