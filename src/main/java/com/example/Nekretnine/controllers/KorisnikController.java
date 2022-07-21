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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Nekretnine.model.ConfirmationToken;
import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.RegistrationRequest;
import com.example.Nekretnine.repository.KorisnikRepository;
import com.example.Nekretnine.service.ConfirmationTokenService;
import com.example.Nekretnine.service.KorisnikService;
import com.example.Nekretnine.service.RegistrationService;

@Controller
@RequestMapping
public class KorisnikController {
	
	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Autowired
    private RegistrationService registrationService;
	
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	@Autowired
	private KorisnikService korisnikService;
	
	@GetMapping(value="/login")
	public String login(Model m, @RequestParam(value = "error", required = false) String error ) {
		 if (null != error && error.equalsIgnoreCase("true")){
	            m.addAttribute("message", "Unable to Login");
	     }
	     return "login";
	}
	

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
        	m.addAttribute("message", "Token je istekao!");
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        korisnikService.enableAppUser(
                confirmationToken.getKorisnik().getEmail());
        m.addAttribute("message", "Uspesna registracija! Mozete se ulogovati"); 
        return "login";
    }
	

	@GetMapping(value="/agenti")
	public String sviAgenti(Model m) {
		List<Korisnik> agenti = korisnikRepository.findByAgencijaNotNull();
		
		
		m.addAttribute("agenti", agenti);
		return "prikaz/PrikazAgenata";
	}
}


