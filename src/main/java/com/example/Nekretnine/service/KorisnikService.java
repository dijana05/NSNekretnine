package com.example.Nekretnine.service;

import com.example.Nekretnine.model.Korisnik;

public interface KorisnikService {
	
	public String signUpUser(Korisnik korisnik);
	
	public void enableAppUser(String email);
}
