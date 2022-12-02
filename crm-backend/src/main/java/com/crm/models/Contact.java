package com.crm.models;

import java.util.Calendar;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Contact{
	public enum ContactType {
	    CALL,
	    EMAIL,
	    VISIT,
	    OTHER
	    
	    
	  }
	
	private int id;
	private boolean isDeleted;
	
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
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
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Contact(Date date, ContactType type, Opportunity opportunity) {
		super();
		id=0;
		this.date = date;
		this.type = type;
		this.opportunity = opportunity;
		accepted=false;
	}
	
	public Contact(@JsonProperty("date") Date date, @JsonProperty("type") String type, @JsonProperty("opportunity") int opportunityId) {
		super();
		id=0;
		this.type=ContactType.valueOf(type);
		this.date = date;
		accepted=false;
	}
	
}
