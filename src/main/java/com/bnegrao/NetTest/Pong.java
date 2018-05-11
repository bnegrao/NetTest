package com.bnegrao.NetTest;

import java.text.DateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Pong {
	private String message;
	private Date date;
	
	public Pong() {
		
		setMessage("pong");
		setDate(new Date());
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	public Date getDate() {
		return date;
	}
	
	public String getCreationDate() {
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(this.date);
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
