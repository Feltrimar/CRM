package com.crm.services.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
				Date date = new Date();
				Contact x= new Contact(date,ContactType.CALL,y);
				Boolean bool = false;
				bool=contactService.createContact(x);
				Assert.isTrue(bool&&contactRepository.getAllContacts().size()==1);
			}
			
		//Testing trying to create directly a opportunity with the same parameters IT MUST NOT SEND ERROR
			@Test
			public void testSuccessCreateDuplicatedContact(){
				Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact x= new Contact(date,ContactType.CALL,y);
				Boolean bool = false;
				contactRepository.setUp();
				bool=contactService.createContact(x);
				Assert.isTrue(bool&&contactRepository.getAllContacts().size()==2);
			}
			
			@Test
			public void ListContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Opportunity y= new Opportunity("Felipo","Trinidad","feipetm@gmail.com","601101754");
				Opportunity z= new Opportunity("Felipi","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date,ContactType.CALL,y);
				Contact c= new Contact(date,ContactType.CALL,z);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getAllContacts().size()==3);
			}
			
			@Test
			public void ListCallContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Opportunity y= new Opportunity("Felipo","Trinidad","feipetm@gmail.com","601101754");
				Opportunity z= new Opportunity("Felipi","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date,ContactType.CALL,y);
				Contact c= new Contact(date,ContactType.CALL,z);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getContactsByType(0).size()==3);
			}
			
			@Test
			public void ListEmailContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Opportunity y= new Opportunity("Felipo","Trinidad","feipetm@gmail.com","601101754");
				Opportunity z= new Opportunity("Felipi","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date,ContactType.EMAIL,y);
				Contact c= new Contact(date,ContactType.CALL,z);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getContactsByType(1).size()==1);
			}
			
			@Test
			public void ListVisitContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Opportunity y= new Opportunity("Felipo","Trinidad","feipetm@gmail.com","601101754");
				Opportunity z= new Opportunity("Felipi","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.VISIT,x);
				Contact b= new Contact(date,ContactType.CALL,y);
				Contact c= new Contact(date,ContactType.VISIT,z);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getContactsByType(2).size()==2);
			}
			
			@Test
			public void ListOtherContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Opportunity y= new Opportunity("Felipo","Trinidad","feipetm@gmail.com","601101754");
				Opportunity z= new Opportunity("Felipi","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date,ContactType.CALL,y);
				Contact c= new Contact(date,ContactType.CALL,z);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getContactsByType(3).size()==0);
			}
			
			@Test
			public void ListContactsOfAOpportunity(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date,ContactType.VISIT,x);
				Contact c= new Contact(date,ContactType.CALL,x);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getContacts(x).size()==3);
			}
			
			@Test
			public void ListFutureContactsTest(){
				Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
				Date date = new Date();
				Date date2 = new Date(130, 5,3);
				Contact a= new Contact(date,ContactType.CALL,x);
				Contact b= new Contact(date2,ContactType.CALL,x);
				Contact c= new Contact(date,ContactType.CALL,x);
				contactRepository.getAllContacts().add(a);
				contactRepository.getAllContacts().add(b);
				contactRepository.getAllContacts().add(c);
				Assert.isTrue(contactRepository.getFutureContacts(x).size()==1);
			}
	
}

