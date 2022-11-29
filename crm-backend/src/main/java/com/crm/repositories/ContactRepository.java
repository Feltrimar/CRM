package com.crm.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.models.Contact;
import com.crm.models.Opportunity;
import com.crm.models.Contact.ContactType;

@Repository
public class ContactRepository {
    private List<Contact> list = new ArrayList<Contact>();

	public List<Contact> getAllContacts() {
		return list;
	}

	public void setUp() {
		Calendar date = Calendar.getInstance();
		Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		Contact x= new Contact(date,ContactType.CALL,y);		
	}
    
}
