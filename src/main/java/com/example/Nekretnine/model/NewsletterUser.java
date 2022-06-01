package com.example.Nekretnine.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="NewsletterUser")
public class NewsletterUser {
	
	@Id
	private String Id;
	private String email;
	private Date datumPrijave;
	
	public NewsletterUser(String email, Date datumPrijave) {
		this.email = email;
		this.datumPrijave = datumPrijave;
	}
	
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDatumPrijave() {
		return datumPrijave;
	}
	
	public void setDatumPrijave(Date datumPrijave) {
		this.datumPrijave = datumPrijave;
	}
	
	

}
