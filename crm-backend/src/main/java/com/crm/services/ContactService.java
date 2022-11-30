package com.crm.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.models.Contact;
import com.crm.models.Contact.ContactType;
import com.crm.models.Opportunity;
import com.crm.repositories.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository repository;

	public Boolean createContact(Contact x) {
		return createContact(x.getDate(),x.getType(),x.getOpportunity());
	}

	private Boolean createContact(Calendar date, ContactType type, Opportunity opportunity) {
		Contact c=new Contact(date,type,opportunity);
		c.setId(repository.getAllContacts().size());
		return repository.getAllContacts().add(c);
		}
	
	public List<Contact> getContacts() {
		return repository.getAllContacts();
		}
	
	public List<Contact> getValidContacts() {
			return repository.getActiveContacts();
		}
		
	public Contact getContactById(int id) {
			return repository.getContactById(id);
		}
		
	public void deleteContact(int id) {
		repository.deleteContact(id);
		}
	
	public List<Contact> getContactsByType(int type) {
		return repository.getContactsByType(type);
		}
}
