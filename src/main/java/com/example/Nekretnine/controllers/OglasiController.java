package com.example.Nekretnine.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.Nekretnina;
import com.example.Nekretnine.model.Oglas;
import com.example.Nekretnine.repository.NekretnineRepository;
import com.example.Nekretnine.repository.OglasiRepository;

@Controller
@RequestMapping(value="/oglasi")
public class OglasiController {

	@Autowired
	NekretnineRepository nekretnineRepository;
	
	@Autowired
	OglasiRepository oglasiRepository;
	
	@GetMapping(value="/unosOglasa")
	public String noviOglasNekretnina(String nekretnina, Model m) {
		Nekretnina n = nekretnineRepository.findById(nekretnina).get();
		m.addAttribute("nekretnina", n);
		return "unos/UnosOglasNekretnina";
	}
	
	@PostMapping(value="/noviOglas")
	public String oglasZaNekretninu(String tekst, String nekretnina, Double cena, HttpServletRequest request, Model m) { //TO DO Popraviti? + Cena double ili String
		//korisnik k
		System.out.println(tekst + nekretnina + cena);
		Nekretnina n = nekretnineRepository.findById(nekretnina).get();
		Oglas o = new Oglas();
		o.setNekretnina(n);
		o.setDatumKreiranja(new Date());
		o.setKreirao(new Korisnik());
		o.setStatus("aktivan");
		if(!tekst.isEmpty())
			o.setTekst(tekst);
		if(cena == null) 
			o.setCena(1.0);
		else
			o.setCena(cena);
		
		oglasiRepository.save(o);
		m.addAttribute("message", "Uspesno dodat oglas ID "+ o.getOglasID());
		
		return sviOglasi(m, n);
		
		
	}
	
	@GetMapping(value="/sviAktivniOglasi")
	public String sviOglasi(Model m, Nekretnina n) {
		m.addAttribute("nekretnina", n);
		m.addAttribute("sviOglasi", oglasiRepository.findByStatus("aktivan"));
		return "prikaz/prikazSvihOglasa";
	}
	
	@GetMapping(value="/prikazOglasa")
	public String prikazOglasa(String id, Model m) {
		Oglas oglas = oglasiRepository.findById(id).get();
		m.addAttribute("oglas", oglas);
		
		return "prikaz/PrikazOglasa";
	}
	
	@RequestMapping(value="/izmena")
	public String izmenaOglasa(String id, Model m) {
		Oglas o = oglasiRepository.findById(id).get();
		m.addAttribute("oglas", o);	
		return "prikaz/PrikazIzmenaOglasa";
	}
	
	@RequestMapping(value="/update")
	public String update(String oglasid, String tekst, String cena, HttpServletRequest request, Model m) {
		Oglas o = oglasiRepository.findById(oglasid).get();
		o.setDatumKreiranja(new Date());
		o.setTekst(tekst);
		o.setCena(Double.parseDouble(cena));
		
		oglasiRepository.save(o);
			
		return mojiOglasi(m);
	}
	
	@GetMapping(value = "/mojiOglasi") // to do moji
	public String mojiOglasi(Model m) {
		List<Oglas> oglasi = oglasiRepository.findAll();
		m.addAttribute("sviOglasi", oglasi);
		return "prikaz/prikazSvihOglasa";
	}
	
	@RequestMapping(value="/sviOglasiSvi")
	public String sviOglasiSvi(HttpServletRequest request, Model m) {
		List<Oglas> hit = new ArrayList<Oglas>();
		hit = oglasiRepository.findTop5ByOrderByCenaDesc();
		m.addAttribute("hit", hit);
		m.addAttribute("sviOglasi", oglasiRepository.findAll());
		return "index";
	}
}