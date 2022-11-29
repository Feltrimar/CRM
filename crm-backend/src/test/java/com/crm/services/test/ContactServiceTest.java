package com.crm.services.test;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.crm.models.Contact;
import com.crm.models.Contact.ContactType;
import com.crm.models.Opportunity;
import com.crm.repositories.ContactRepository;
import com.crm.repositories.OpportunityRepository;
import com.crm.services.ContactService;
import com.crm.services.OpportunityService;

@SpringBootTest
public class ContactServiceTest {

	@Autowired
	ContactService contactService;
	@Autowired
	ContactRepository contactRepository;
	
	@BeforeEach
	public void init() {
		contactRepository.getAllContacts().clear();
	}
	
	//Testing trying to create a new Opportunity
		@Test
			public void testCreateContact(){
				Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Calendar date = Calendar.getInstance();
				Contact x= new Contact(date,ContactType.CALL,y);
				Boolean bool = false;
				bool=contactService.createContact(x);
				Assert.isTrue(bool&&contactRepository.getAllContacts().size()==1);
			}
			
		//Testing trying to create directly a opportunity with the same parameters IT MUST NOT SEND ERROR
			@Test
			public void testErrorCreateDuplicatedContact(){
				Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Calendar date = Calendar.getInstance();
				Contact x= new Contact(date,ContactType.CALL,y);
				Boolean bool = false;
				contactRepository.setUp();
				bool=contactService.createContact(x);
				Assert.isTrue(!bool&&contactRepository.getAllContacts().size()==1);
			}
	
}

