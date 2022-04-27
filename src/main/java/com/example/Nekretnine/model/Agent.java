package com.example.Nekretnine.model;

public class Agent extends Korisnik {

	private Agencija agencija;
	
	public Agent(String email, String sifra) {
		super(email, sifra);
	}

	public Agent() {
	}

	public Agencija getAgencija() {
		return agencija;
	}

	public void setAgencija(Agencija agencija) {
		this.agencija = agencija;
	}
	
	

}
