package com.crm.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Opportunity {
	private int id;
	private boolean isCustomer=false;
	private boolean isDeleted=false;
	private String name;
	private String surname;
	private String email;
	private String telephone;
	List<Contact> contacts;
	
	public Opportunity(String name, String surname, String email, String telephone) {
		super();
		id=0;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		contacts = new ArrayList<Contact>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCustomer() {
		return isCustomer;
	}

	public void setCustomer(boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

}
