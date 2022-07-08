package com.example.Nekretnine.model;

import java.util.Collection;
import java.util.Collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection="korisnik")
public class Korisnik  implements UserDetails{
	
	/**
	 * ??
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String korisnikID;
	@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	
	private String email;
	private String sifra;
	private String ime;
	private String prezime;
	private String brojTelefona;
	private Agencija agencija;
	
	private Uloga uloga;
	private boolean locked;
	private boolean enabled;

	public Korisnik() {
		
	}
	
	public Korisnik(String email, String sifra) {
		super();
		this.email = email;
		this.sifra = sifra;
	}
	

	public Korisnik(String ime, String sifra, String email, String prezime, String brojTelefona, Uloga uloga) {
		this.email = email;
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
	}
	
	public Korisnik(String ime, String sifra, String email, String prezime, String brojTelefona, Uloga uloga, Agencija agencija) {
		this.email = email;
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.uloga = uloga;
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
	
	
	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public Agencija getAgencija() {
		return agencija;
	}

	public void setAgencija(Agencija agencija) {
		this.agencija = agencija;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(uloga.name()); 
		return null;
		//return Collections.singletonList(authority);
	}

	public String getPassword() {
		return sifra;
	}

	public String getUsername() {
		return email;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return !locked;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	
}
