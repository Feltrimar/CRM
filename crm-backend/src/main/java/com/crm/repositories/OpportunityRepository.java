package com.crm.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.models.Opportunity;
import com.crm.models.User;

@Repository
public class OpportunityRepository {
    private List<Opportunity> list = new ArrayList<Opportunity>();
    
    public void setUp() {
    	Opportunity x= new Opportunity("Felipe","Trinidad","feipetm@gmail.com","601101754");
        list.add(x);
        }
    
    public List<Opportunity> getAllOpportunities() {
        return list;
    }

	public List<Opportunity> getAllCustomers() {
		List<Opportunity> res= new ArrayList<Opportunity>();
		for(Opportunity o: list) {
			if(o.isCustomer()) {
				res.add(o);
			}
		}
		return res;
	}
	
	public List<Opportunity> getAllNonCustomers() {
		List<Opportunity> res= new ArrayList<Opportunity>();
		for(Opportunity o: list) {
			if(!o.isCustomer()) {
				res.add(o);
			}
		}
		return res;
	}
	
	
    
}
