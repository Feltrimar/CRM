package com.crm.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.crm.models.Contact;

@Repository
public class ContactRepository {
    private List<Contact> list = new ArrayList<Contact>();
    
}
