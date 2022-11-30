package com.crm.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.models.Contact;
import com.crm.models.Opportunity;
import com.crm.services.OpportunityService;
import com.crm.models.Contact.ContactType;

@Repository
public class ContactRepository {
	
	
    private List<Contact> list = start();
    
    public List<Contact> getAllContacts() {
		return list;
	}
    
	private List<Contact> start() {
		Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		Calendar date = Calendar.getInstance();
		Contact a= new Contact(date,ContactType.CALL,x);
		List<Contact> lista = new ArrayList<Contact>();
		lista.add(a);
		return lista;
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
			if(o.getOpportunity().equals(x)&&o.getDate().after(date)&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}

	public List<Contact> getContacts(Opportunity x) {
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getOpportunity().equals(x)&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}

	public List<Contact> getContactsByType(int type0) {
		ContactType type = null;
		switch(type0){
		case 0:
			type= ContactType.CALL;
		break;
		case 1:
			type= ContactType.EMAIL;
		break;
		case 2:
			type= ContactType.VISIT;
		break;
		case 3:
			type= ContactType.OTHER;
		break;
		}
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getType().equals(type)&&!o.isDeleted()) {
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
		Opportunity o=x.getOpportunity();
			if(o.getContacts().contains(x)&&o.isDeleted()==false) {
			o.getContacts().remove(x);
		
		
	  }    
	}
}
