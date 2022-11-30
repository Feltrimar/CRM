package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.models.Contact;
import com.crm.models.Contact.ContactType;
import com.crm.services.ContactService;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactController {

	@Autowired
    private ContactService service;

	@PostMapping
    public Boolean createContact(@RequestBody Contact x) {
        return service.createContact(x);
    }
	
	@GetMapping("all")
	public List<Contact> getContacts(){
		return service.getContacts();
		
	}
	
	@GetMapping("valid")
	public List<Contact> getValidContacts(){
		return service.getValidContacts();
		
	}
	
	
	@GetMapping("{id}")
	public Contact getContact(@PathVariable int id){
		return service.getContactById(id);
		
	}
	
	@GetMapping("type/{id}")
	public List<Contact> getContactByType(@PathVariable int id){
		return service.getContactsByType(id);
		
	}

	@DeleteMapping("{id}")
    public void deleteContact(@PathVariable int id) {
        service.deleteContact(id);
    }
}
