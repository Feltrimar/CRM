package com.crm.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.models.Contact;
import com.crm.models.Opportunity;
import com.crm.models.User;

@Repository
public class OpportunityRepository {
	@Autowired
	private ContactRepository cR;
	
    private List<Opportunity> list = new ArrayList<Opportunity>();
    
    public void setUp() {
    	Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
        list.add(x);
        }
    
    public List<Opportunity> getAllOpportunities() {
		return list;
    }
    
    public List<Opportunity> getActiveOpportunities() {
    	List<Opportunity> res= new ArrayList<Opportunity>();
		for(Opportunity o: list) {
			if(!o.isDeleted()) {
				res.add(o);
			}
		}
		System.out.println(list.size() +", "+ res.size());
		return res;
    }

	public List<Opportunity> getAllCustomers() {
		List<Opportunity> res= new ArrayList<Opportunity>();
		System.out.println(list.size());
		for(Opportunity o: list) {
			if(o.isCustomer()&&!o.isDeleted()) {
				res.add(o);
			}
		}
		System.out.println(res.size());
		return res;
	}
	
	public List<Opportunity> getAllNonCustomers() {
		List<Opportunity> res= new ArrayList<Opportunity>();
		for(Opportunity o: list) {
			if(!o.isCustomer()&&!o.isDeleted()) {
				res.add(o);
			}
		}
		return res;
	}
	public Opportunity getOpportunityById(int id) {
		Opportunity res = null;
		for(Opportunity o: list) {
			if(o.getId()==id) {
				res=o;
				break;
			}
		}
		return res;
	}
	
	public void deleteOpportunity(int id) {
		Opportunity x = getOpportunityById(id);
		x.setDeleted(true);
		for(Contact o: cR.getAllContacts()) {
			if(o.getOpportunity()==x&&o.isDeleted()==false) {
			cR.deleteContact(o.getId());
		}
		
	  }    
	}
    
}
