package com.example.Nekretnine.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="korisnik")
public class Korisnik {
	
	@Id
	private String korisnikID;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	
	private String email;
	private String sifra;
	private String ime;
	private String prezime;
	private String uloga;
	private boolean loggedIn;
	private String brojTelefona;
	
	
	public Korisnik(String email, String sifra) {
		super();
		this.email = email;
		this.sifra = sifra;
	}

	public Korisnik() {
	}

	public String getKorisnikID() {
		return korisnikID;
	}

	public void setKorisnikID(String korisnikID) {
		this.korisnikID = korisnikID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	
}
