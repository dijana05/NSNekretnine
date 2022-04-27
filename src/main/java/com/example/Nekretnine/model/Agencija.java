package com.example.Nekretnine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="agencija")
public class Agencija {
	
	@Id
	private String id;
	private String naziv, adresa;
	private Integer brojLicence;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Integer getBrojLicence() {
		return brojLicence;
	}
	public void setBrojLicence(Integer brojLicence) {
		this.brojLicence = brojLicence;
	}
}
