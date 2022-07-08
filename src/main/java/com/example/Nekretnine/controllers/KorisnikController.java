package com.example.Nekretnine.controllers;

import java.time.LocalDateTime;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Nekretnine.model.Agent;
import com.example.Nekretnine.model.ConfirmationToken;
import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.RegistrationRequest;
import com.example.Nekretnine.repository.AgencijaRepository;
import com.example.Nekretnine.repository.KorisnikRepository;
import com.example.Nekretnine.service.impl.ConfirmationTokenService;
import com.example.Nekretnine.service.impl.KorisnikService;
import com.example.Nekretnine.service.impl.RegistrationService;

@Controller
@RequestMapping(value="/korisnik")
public class KorisnikController {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
    private RegistrationService registrationService;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	
	@GetMapping(value="/agenti")
	public String sviAgenti(Model m) {
		List<Agent> agenti = korisnikRepository.findByAgencijaNotNull();
		
		
		m.addAttribute("agenti", agenti);
		return "prikaz/PrikazAgenata";
	}
	
	@Autowired
	KorisnikRepository kr;
	@Autowired
	AgencijaRepository ar;
	@Autowired
	OglasiController oc;
	
	@RequestMapping(value="/loginPage", method=RequestMethod.GET)
	public String loginPage(){
		return "login";
	}

	/*
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(HttpServletRequest request, Model m) {
		Korisnik user = (Korisnik) kr.findByEmailAndSifra(request.getParameter("username"), request.getParameter("password"));
		if (user != null) {
	    	request.getSession().setAttribute("user", user);
	    	request.getSession().setAttribute("uloga", user.getUloga());
	    } else {
	    	m.addAttribute("message", "Username ili password nisu korektni!");
	    	return "login";
	  	}
		return oc.sviOglasiSvi(m);
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, Model m) {
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("uloga");
		return oc.sviOglasiSvi(m);
	}
	*/
/*	
	@RequestMapping(value="izborAgencije")
	public String izaberiAgenciju( Korisnik korisnik, Model m, HttpServletRequest request) throws IOException {
		request.getSession().setAttribute("korisnik", korisnik);
		if(korisnik.getUloga().equals("agencija")) {
			List<Agencija> agencije = ar.findAll();
			m.addAttribute("agencije", agencije);
			return "prikaz/izborAgencije";
		}
		
		return registrujKorisnika(m, korisnik, null, request);
	}
*/	
	@RequestMapping(value="registracijaPage" , method=RequestMethod.GET)
	public String registrujPage(Model m) {
		return "registracija";
	}
/*			
			
/*			
	@RequestMapping(value="registracija" , method=RequestMethod.POST)
	public String registrujKorisnika(Model m, Korisnik korisnik, String agencija, HttpServletRequest request) throws IOException  {
		korisnik = (Korisnik) request.getSession().getAttribute("korisnik");
		if(korisnik.getUloga().equals("agencija")) {
			Agencija a = ar.findById(agencija).get();
			//korisnik.setAgencija(a);
			Agent agent = (Agent) request.getSession().getAttribute("korisnik");
			System.out.println(agent.toString());
		}
		kr.save(korisnik);
		m.addAttribute("message", "Uspesna registracija! Mozete se ulogovati!");
		return "login";
	}
*/
	
	@PostMapping(value="/registracija")
    public String register(Model m, RegistrationRequest request) {
		boolean validEmail = isValidEmail(request.getEmail());
		if(!validEmail) {
			m.addAttribute("message", "Email nije validan!");
			return "registracija";
		}
		
		boolean exist = korisnikRepository.findByEmail(request.getEmail()).isPresent();
		if(exist) {
			m.addAttribute("message", "Imate registrovan profil! Mozete se prijaviti");
			return "login";
		}
		
		//TO DO: proveriti kada token nije potvrdjen 
		
		
        return registrationService.register(m,request);
    }
	
	
	private boolean isValidEmail(String email) {
		boolean result = true;
		try {
			InternetAddress emailAdress = new InternetAddress(email);
			emailAdress.validate();
		}catch(AddressException a) {
			result = false;
		}
		return result;
	}

	@Transactional
	@GetMapping(value="/registracija/confirm")
    public String confirmToken(Model m, String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        korisnikService.enableAppUser(
                confirmationToken.getKorisnik().getEmail());
        m.addAttribute("message", "Uspesna registracija! Mozete se ulogovati");
        return "login";
    }
	
	
}


