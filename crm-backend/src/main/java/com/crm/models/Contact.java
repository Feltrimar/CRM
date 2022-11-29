package com.crm.models;

import java.util.Calendar;

import lombok.Data;

@Data
public class Contact {
	public enum ContactType {
	    CALL,
	    EMAIL,
	    VISIT,
	    OTHER
	  }
	
	private int id;
	private boolean isDeleted;
	private Calendar date;
	private ContactType type;
	private Opportunity opportunity;
	private boolean accepted;
	private String reason;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public ContactType getType() {
		return type;
	}

	public void setType(ContactType type) {
		this.type = type;
	}

	public Opportunity getOpportunity() {
		return opportunity;
	}

	public void setOpportunity(Opportunity opportunity) {
		this.opportunity = opportunity;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Contact(Calendar date, ContactType type, Opportunity opportunity) {
		super();
		id=0;
		this.date = date;
		this.type = type;
		this.opportunity = opportunity;
		accepted=false;
	}
	
}
