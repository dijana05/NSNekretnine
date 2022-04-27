package com.example.Nekretnine.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "oglasi")
public class Oglas {
	
	@Id
	private String oglasID;
	private String tekst, status;
	private Double cena;
	private Date datumKreiranja;
	private Nekretnina nekretnina;
	private Korisnik kreirao;
	public String getOglasID() {
		return oglasID;
	}
	public void setOglasID(String oglasID) {
		this.oglasID = oglasID;
	}
	public String getTekst() {
		return tekst;
	}
	public void setTekst(String tekst) {
		this.tekst = tekst;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getCena() {
		return cena;
	}
	public void setCena(Double cena) {
		this.cena = cena;
	}
	public Date getDatumKreiranja() {
		return datumKreiranja;
	}
	public void setDatumKreiranja(Date datumKreiranja) {
		this.datumKreiranja = datumKreiranja;
	}
	public Nekretnina getNekretnina() {
		return nekretnina;
	}
	public void setNekretnina(Nekretnina nekretnina) {
		this.nekretnina = nekretnina;
	}
	public Korisnik getKreirao() {
		return kreirao;
	}
	public void setKreirao(Korisnik kreirao) {
		this.kreirao = kreirao;
	}
	
	

}
