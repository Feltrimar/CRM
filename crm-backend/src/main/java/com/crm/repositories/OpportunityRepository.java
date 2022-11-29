package com.crm.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.models.Opportunity;

@Repository
public class OpportunityRepository {
    private List<Opportunity> list = new ArrayList<Opportunity>();
    
}
