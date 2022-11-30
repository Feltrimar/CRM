package com.crm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.models.Contact;
import com.crm.models.Opportunity;
import com.crm.services.OpportunityService;
import com.crm.services.UserService;

@RestController
@RequestMapping("/api/v1/opportunities")
public class OpportunityController {
	
	@Autowired
    private OpportunityService service;

	@PostMapping
    public Boolean createOpportunity(@RequestBody Opportunity x) {
        return service.createOpportunity(x);
    }
	
	@GetMapping
	public List<Opportunity> getOpportunities(){
		return service.getOpportunities();
		
	}
	
	@GetMapping("customers")
	public List<Opportunity> getCustomers(){
		return service.getAllCustomers();
		
	}
	
	@GetMapping("nonCustomers")
	public List<Opportunity> getNonCustomers(){
		return service.getNonCustomers();
		
	}
	
	@GetMapping("{id}")
	public Opportunity getOpportunity(@PathVariable int id){
		return service.getOpportunityById(id);
		
	}
	
	@DeleteMapping("{id}")
    public void deleteOpportunity(@PathVariable int id) {
        service.deleteOpportunity(id);
    }
	
}
