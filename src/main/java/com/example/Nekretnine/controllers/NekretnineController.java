package com.example.Nekretnine.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.Nekretnina;
import com.example.Nekretnine.model.Oglas;
import com.example.Nekretnine.repository.NekretnineRepository;
import com.example.Nekretnine.repository.OglasiRepository;

@Controller
@RequestMapping(value="/nekretnine")
public class NekretnineController {
	
	@Autowired
	NekretnineRepository nekretnineRepository;
	@Autowired
	OglasiRepository oglasiRepository;
	
	private static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/images/uploads";
	
	
	
	@GetMapping(value="/unosNekretnine")
	public String unesiNekretninu(HttpServletRequest request, Model m) {
		return "unos/UnosNekretnine";
	}
	
	
	//Unos nove nekretnine
	@PostMapping(value="/save")
	public String save(Nekretnina n, @RequestParam("slike")MultipartFile[] slike, Model m, HttpServletRequest request) {
		//Filter praznih polja
		Nekretnina filter = filter(n);
		Korisnik k =  (Korisnik) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		filter.setDodao(k);
		nekretnineRepository.save(filter);
		
		//Cuvanje slika u resurse
		List<String> fileNames = new ArrayList<String>();
		for(MultipartFile file : slike) {
			Path fileNameAndPath = Paths.get(uploadDirectory+"/"+filter.getNekretninaID(), file.getOriginalFilename());
			if(Files.notExists(fileNameAndPath)) {
				new File(uploadDirectory+"/"+filter.getNekretninaID()).mkdir();
			}
			try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileNames.add(filter.getNekretninaID()+"/" +file.getOriginalFilename());
			System.out.println("Folder za nekretninu  " + uploadDirectory+"/"+filter.getNekretninaID());
			System.out.println("fileNameAndPath  " +fileNameAndPath);
		}
		
		filter.setSlikeNazivi(fileNames);
		nekretnineRepository.save(filter);
		
		m.addAttribute("nekretnina", n);
		m.addAttribute("poruka", "Uspesno dodata nekretnina");
		return prikazNekretnina(request, m);	
	}
	
	@GetMapping(value="/prikazNekretnina")
	private String prikazNekretnina(HttpServletRequest request, Model m) {
		//Get korinsika
		List<Nekretnina> nekretnine = nekretnineRepository.findAll();
		m.addAttribute("poruka", m.getAttribute("poruka"));
		m.addAttribute("nekretnine", nekretnine);
		return "prikaz/PrikazNekretnina";
	}
	
	@GetMapping(value="/prikazIzmenaNekretnine")
	public String prikazIzmena(String nekretnina, Model m) {
		Nekretnina nekretnina1 = nekretnineRepository.findById(nekretnina).get();
		m.addAttribute("nekretnina", nekretnina1);
		return "prikaz/PrikazIzmenaNekretnine";
	}
	
	@PostMapping(value = "/izmena")
	public String izmenaNekretnine(Nekretnina n, Model m, HttpServletRequest request) {
		Nekretnina filter = filter(n);
		nekretnineRepository.save(filter);
		List<Oglas> oglasi = oglasiRepository.findbyNekretninaID(filter.getNekretninaID());
		for (Oglas o : oglasi) {
			o.setNekretnina(filter);
			oglasiRepository.save(o);
		}
		
		return prikazNekretnina(request, m);
	}
	
	@GetMapping(value = "/brisanje")
	public String brisanjeNekretnine(String nekretnina, Model m, HttpServletRequest request) {
		Nekretnina n = nekretnineRepository.findByNekretninaID(nekretnina).get();
		if(n.getSlikeNazivi() != null) {
			for (String slika : n.getSlikeNazivi())
				try {
					Files.deleteIfExists(Paths.get("/images/uploads/"+slika));
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		nekretnineRepository.deleteById(nekretnina);
		List<Oglas> oglasi = oglasiRepository.findbyNekretninaID(nekretnina);
		for(Oglas o : oglasi) {
			oglasiRepository.deleteById(o.getOglasID());	
		}
		m.addAttribute("poruka", "Uspesno obrisana nekretnina!");
		return prikazNekretnina(request, m);
		
	}
	
	@GetMapping(value="/mojeNekretnine")
	public String mojeNekretnine(Model m, String id) {
		List<Nekretnina> nekrentine = new ArrayList<>();
		
		nekrentine = nekretnineRepository.findByDodaoKorisnikID(id);
		
		
		m.addAttribute("nekretnine", nekrentine);
		return "prikaz/PrikazNekretnina";
	}
	
	
	//Filtrira prazna polja kako ne bi bila uneta u bazu
	//TO DO BOLJI NACIN
	private Nekretnina filter(Nekretnina n) {
		Nekretnina nova = new Nekretnina();
		
		if(n.getNekretninaID() != null && !n.getNekretninaID().isEmpty())
			nova.setNekretninaID(n.getNekretninaID());
		if(n.getPovrsina() != null)
			nova.setPovrsina(n.getPovrsina());
		if(!n.getAdresa().isEmpty())
			nova.setAdresa(n.getAdresa());
		if(n.getDuplex() != null && !n.getDuplex().isEmpty())
			nova.setDuplex(n.getDuplex());
		if(!n.getGrejanje().isEmpty())
			nova.setGrejanje(n.getGrejanje());
		if(!n.getLift().isEmpty())
			nova.setLift(n.getLift());
		if(!n.getNamestenost().isEmpty())
			nova.setNamestenost(n.getNamestenost());
		if(n.getStanje()  != null)
			nova.setStanje(n.getStanje());
		if(n.getBrojSoba() != null)
		
			nova.setBrojSoba(n.getBrojSoba());
		if(!n.getParking().isEmpty())
			nova.setParking(n.getParking());
		if(!n.getUknjizenost().isEmpty())
			nova.setUknjizenost(n.getUknjizenost());
		if(n.getGodinaIzgradnje()!=null)
			nova.setGodinaIzgradnje(n.getGodinaIzgradnje());
		if(n.getSprat()!=null)
			nova.setSprat(n.getSprat());
		if(!n.getDepozit().isEmpty())
			nova.setDepozit(n.getDepozit());
		if(!n.getTip().isEmpty())
			nova.setTip(n.getTip());
		if(n.getDodao() !=null)
			 n.setDodao(n.getDodao());
		
		return nova;
		
	}
	
	@RequestMapping(value="/svePagination")
	public String sveNekretninePagination(Model m, @RequestParam(required = false) String sort,
													@RequestParam(required = false) String id,
													@RequestParam(required = false, defaultValue = "0") int page,
													 @RequestParam(required = false, defaultValue = "5") int size) {
		try {
			List<Nekretnina> sveNekretnine = new ArrayList<Nekretnina>();
			Pageable pageable = PageRequest.of(page, size);
			
			Page<Nekretnina> nekretnineStranica;
			
			if(sort == null && id.isEmpty()) 
				nekretnineStranica = nekretnineRepository.findAll(pageable);
			else if(sort == null && !id.isEmpty()){
				nekretnineStranica = nekretnineRepository.findByDodaoID(id,pageable);
			}
			else if(sort.equals("asc")) {
				nekretnineStranica = nekretnineRepository.findAllByOrderByPovrsinaAsc(pageable);
				m.addAttribute("sort", sort);
			}else {
				nekretnineStranica = nekretnineRepository.findAllByOrderByPovrsinaDesc(pageable);			
				m.addAttribute("sort", sort);
			}
			sveNekretnine = nekretnineStranica.getContent();
			
			m.addAttribute("nekretnine", sveNekretnine);
			m.addAttribute("currPage", nekretnineStranica.getNumber());
			m.addAttribute("ukupnoNekretnina", nekretnineStranica.getTotalElements());
			m.addAttribute("ukupnoStranica", nekretnineStranica.getTotalPages());
			m.addAttribute("curr" , nekretnineStranica.getNumberOfElements());
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
		return "prikaz/PrikazNekretnina";
			
	}
}
