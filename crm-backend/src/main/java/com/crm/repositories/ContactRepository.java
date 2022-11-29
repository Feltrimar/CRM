package com.crm.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.models.Contact;
import com.crm.models.Opportunity;
import com.crm.models.Contact.ContactType;

@Repository
public class ContactRepository {
	@Autowired
	private OpportunityRepository oR;
    private List<Contact> list = new ArrayList<Contact>();
    
    public List<Contact> getAllContacts() {
		return list;
	}
    
	public List<Contact> getActiveContacts() {
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}

	public void setUp() {
		Calendar date = Calendar.getInstance();
		Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		Contact x= new Contact(date,ContactType.CALL,y);
		list.add(x);
	}

	public List<Contact> getFutureContacts(Opportunity x) {
		Calendar date = Calendar.getInstance();
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getOpportunity()==x&&o.getDate().after(date)&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}

	public List<Contact> getContacts(Opportunity x) {
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getOpportunity()==x&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}

	public List<Contact> getContacts(ContactType type) {
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getType()==type&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}
	
	public Contact getContactById(int id) {
		Contact res = null;
		for(Contact o: list) {
			if(o.getId()==id) {
				res=o;
				break;
			}
		}
		return res;
	}
	
	public void deleteContact(int id) {
		Contact x = getContactById(id);
		x.setDeleted(true);
		for(Opportunity o: oR.getAllOpportunities()) {
			if(o.getContacts().contains(x)&&o.isDeleted()==false) {
			o.getContacts().remove(x);
		}
		
	  }    
	}
}
