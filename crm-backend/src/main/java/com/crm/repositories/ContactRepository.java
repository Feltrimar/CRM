package com.crm.repositories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
		Date date = new Date();
		Date date2 = new Date(230,10,10);
		Contact a= new Contact(date,ContactType.CALL,x);
		Contact b= new Contact(date,ContactType.CALL,x);
		b.setId(1);
		Contact c= new Contact(date,ContactType.EMAIL,x);
		c.setId(2);
		c.setAccepted(true);
		Contact d= new Contact(date2,ContactType.VISIT,x);
		d.setId(3);
		a.setReason("No quería trabajar");
		b.setReason("No quería trabajar");
		c.setReason("Quería trabajar");
		d.setReason("No quería trabajar");

		List<Contact> lista = new ArrayList<Contact>();
		lista.add(a);
		lista.add(b);
		lista.add(c);
		lista.add(d);
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
		Date date = new Date();
		Opportunity y= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
		Contact x= new Contact(date,ContactType.CALL,y);
		list.add(x);
	}

	public List<Contact> getFutureContacts(Opportunity x) {
		Date date = new Date();
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getOpportunity().equals(x)&&o.getDate().after(date)&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}
	
	public List<Contact> getFutureContacts() {
		Date date = new Date();
		List<Contact> res= new ArrayList<Contact>();
		for(Contact o: list) {
			if(o.getDate().after(date)&&!o.isDeleted()) {
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
