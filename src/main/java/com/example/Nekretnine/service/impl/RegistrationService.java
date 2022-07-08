package com.example.Nekretnine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.RegistrationRequest;
import com.example.Nekretnine.model.Uloga;
import com.example.Nekretnine.service.EmailSender;

@Service
public class RegistrationService {
	@Autowired
	private KorisnikService korisnikService;
	@Autowired
	private EmailSender emailSender;
	
	public String register(Model m,RegistrationRequest request) {
		String token = korisnikService.signUpUser(new Korisnik(
																request.getFirstName(),
																request.getLastName(),
																request.getEmail(),
																request.getPassword(),
																"065111111",
																Uloga.USER
																)
				);
		
		String link = "http://localhost:8082/korisnik/registracija/confirm?token=" + token;
		emailSender.sendEmail(request.getEmail(), "Confirmation token", buildEmail(request.getFirstName(), link));
		m.addAttribute("message", "Token za potvrdu vam je posalt na e-mail "+ request.getEmail());
		return "login";
	}
	
	private String buildEmail(String name, String link) {
        return 
                " Hi " + name + " Thank you for registering. "
                		+ "Please click on the below link to activate your account:"
                		+ " <blockquote style=\"Margin:0 0 20px 0;border-left:10px solid #b1b4b6;padding:15px 0 0.1px 15px;font-size:19px;line-height:25px\">"
                		+ "		<p style=\"Margin:0 0 20px 0;font-size:19px;line-height:25px;color:#0b0c0c\"> "
                		+ "			<a href=\"" + link + "\">Activate Now"
                				+ "	</a> "
                		+      "</p>"
                		+ "</blockquote>\n Link will expire in 15 minutes. <p>See you soon</p>";
                    
    }
}
