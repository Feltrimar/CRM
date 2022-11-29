package com.crm.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.models.Contact;
import com.crm.models.Contact.ContactType;
import com.crm.models.Opportunity;
import com.crm.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	public Boolean createContact(Contact x) {
		return createContact(x.getDate(),x.getType(),x.getOpportunity());
	}

	private Boolean createContact(Calendar date, ContactType type, Opportunity opportunity) {
		Contact c=new Contact(date,type,opportunity);
		c.setId(contactRepository.getAllContacts().size());
		return contactRepository.getAllContacts().add(c);
	}
	
	
}
