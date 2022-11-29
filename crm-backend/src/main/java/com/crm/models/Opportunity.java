package com.crm.models;

import java.util.List;

import lombok.Data;

@Data
public class Opportunity {
	private int id;
	private boolean isCustomer;
	private boolean isDeleted;
	private String name;
	private String surname;
	private String email;
	private String telephone;
	List<Contact> contacts;
	
	
	public Opportunity(int id, String name, String surname, String email, String telephone, List<Contact> contacts) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.telephone = telephone;
		this.contacts = contacts;
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
