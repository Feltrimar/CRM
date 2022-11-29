package com.crm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.models.Opportunity;
import com.crm.models.User;
import com.crm.repositories.OpportunityRepository;
import com.crm.repositories.UserRepository;

@Service
public class OpportunityService {

	@Autowired
	private OpportunityRepository repository;
	
	public Boolean createOpportunity(Opportunity x) {
		return createOpportunity(x.getName(),x.getSurname(),x.getEmail(),x.getTelephone(), x.isCustomer());
	}
	
	public Boolean createOpportunity(String name, String surname, String email, String telephone, boolean customer) {
		boolean aux=false;
		List<Opportunity> ops=getOpportunities();
		if(customer==false) {
		aux=checkValidOpportunity(name,surname,email,telephone);
		if(aux) {
			Opportunity x= new Opportunity(name,surname,email,telephone);
			x.setId(ops.size());
			ops.add(x);
		} else {
			System.out.println("This person is already in the database");
			}
		
		}else {
			System.out.println("You cannot add a new person directly as a Customer");
		}
		return aux;
	}

	public Boolean checkValidOpportunity(String name, String surname, String email, String telephone) {
		boolean res=true;
		List<Opportunity> aux=getOpportunities();
		for(Opportunity o: aux) {
			if(o.getName() == name && o.getSurname() == surname && o.getEmail() == email && o.getTelephone() == telephone) {
					res = false;
					break;
			}
		}
		return res;
	}
		
	public List<Opportunity> getOpportunities() {
			return repository.getAllOpportunities();
		}
		
	public List<Opportunity> getValidOpportunities() {
			return repository.getActiveOpportunities();
		}
		
	public List<Opportunity> getAllCustomers() {
			return repository.getAllCustomers();
		}
		
	public List<Opportunity> getNonCustomers() {
			return repository.getAllNonCustomers();
		}
		
	public Opportunity getOpportunityById(int id) {
			return repository.getOpportunityById(id);
		}
		
	public void deleteOpportunity(int id) {
		repository.deleteOpportunity(id);
	}
}
