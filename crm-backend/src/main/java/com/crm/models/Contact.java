package com.crm.models;

import java.util.Calendar;

public class Contact {
	enum Type {
	    CALL,
	    EMAIL,
	    VISIT,
	    OTHER
	  }
	
	private int id;
	private boolean isDeleted;
	private Calendar date;
	private Type type;
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

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
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

	public Contact(int id, Calendar date, Type type, Opportunity opportunity, boolean accepted, String reason) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.opportunity = opportunity;
		this.accepted = accepted;
		this.reason = reason;
	}
	
}
