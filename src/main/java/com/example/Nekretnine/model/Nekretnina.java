package com.example.Nekretnine.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Nekretnine")
public class Nekretnina {
	
	@Id
	private String nekretninaID;
	
	private String tip, uknjizenost, grejanje, namestenost, lift, duplex,parking, depozit, adresa;
	private Integer povrsina,sprat,godinaIzgradnje, stanje;
	private Double  brojSoba;
	private Korisnik dodao;
	private List<String> slikeNazivi;
	
	
	
	public String getNekretninaID() {
		return nekretninaID;
	}
	public void setNekretninaID(String nekretninaID) {
		this.nekretninaID = nekretninaID;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getUknjizenost() {
		return uknjizenost;
	}
	public void setUknjizenost(String uknjizenost) {
		this.uknjizenost = uknjizenost;
	}
	public String getGrejanje() {
		return grejanje;
	}
	public void setGrejanje(String grejanje) {
		this.grejanje = grejanje;
	}
	public String getNamestenost() {
		return namestenost;
	}
	public void setNamestenost(String namestenost) {
		this.namestenost = namestenost;
	}
	public String getLift() {
		return lift;
	}
	public void setLift(String lift) {
		this.lift = lift;
	}
	public String getDuplex() {
		return duplex;
	}
	public void setDuplex(String duplex) {
		this.duplex = duplex;
	}
	public String getParking() {
		return parking;
	}
	public void setParking(String parking) {
		this.parking = parking;
	}
	public String getDepozit() {
		return depozit;
	}
	public void setDepozit(String depozit) {
		this.depozit = depozit;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Integer getPovrsina() {
		return povrsina;
	}
	public void setPovrsina(Integer povrsina) {
		this.povrsina = povrsina;
	}
	public Integer getSprat() {
		return sprat;
	}
	public void setSprat(Integer sprat) {
		this.sprat = sprat;
	}
	public Integer getGodinaIzgradnje() {
		return godinaIzgradnje;
	}
	public void setGodinaIzgradnje(Integer godinaIzgradnje) {
		this.godinaIzgradnje = godinaIzgradnje;
	}
	public Integer getStanje() {
		return stanje;
	}
	public void setStanje(Integer stanje) {
		this.stanje = stanje;
	}
	public Double getBrojSoba() {
		return brojSoba;
	}
	public void setBrojSoba(Double brojSoba) {
		this.brojSoba = brojSoba;
	}
	
	public Korisnik getDodao() {
		return dodao;
	}
	public void setDodao(Korisnik dodao) {
		this.dodao = dodao;
	}
	public List<String> getSlikeNazivi() {
		return slikeNazivi;
	}
	public void setSlikeNazivi(List<String> slikeNazivi) {
		this.slikeNazivi = slikeNazivi;
	}
	
	
	
	
}
