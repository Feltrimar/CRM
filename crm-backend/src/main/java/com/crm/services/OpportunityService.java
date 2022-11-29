package com.crm.services;

import org.springframework.stereotype.Service;

import com.crm.models.Opportunity;

@Service
public class OpportunityService {

	public Boolean createOpportunity(Opportunity x) {
		return createOpportunity(x.getName(),x.getSurname(),x.getEmail(),x.getTelephone(), x.isCustomer());
	}
	
	public Boolean createOpportunity(String name, String surname, String email, String telephone, boolean customer) {
		return null;
	}

}
