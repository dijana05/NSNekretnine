package com.example.Nekretnine.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Nekretnine.IndexController;
import com.example.Nekretnine.model.NewsletterUser;
import com.example.Nekretnine.repository.NewsletterRepository;
import com.example.Nekretnine.service.NewsletterService;
import com.mongodb.client.DistinctIterable;
import com.mongodb.client.MongoCursor;

@Controller
@RequestMapping(value="/newsletter")
public class NewsletterController {
	
	@Autowired
	public NewsletterRepository newsletterRepository;
	
	@Autowired
	public NewsletterService newsletterService;
	
	@Autowired
	public IndexController indexController;
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	
	@GetMapping(value="/new")
	public String createNewNewsletter() {
		return "unos/NewNewsletter";
	}

	@PostMapping(value="/send-mail")
	public String sendNewsletter(Model m, String sub, String mess) {
	
		DistinctIterable<String> dsc =  mongoTemplate.getCollection("NewsletterUser").distinct("email", String.class);
		MongoCursor<String> cursor = dsc.iterator();
		
		while(cursor.hasNext()) {
			try {
				newsletterService.sendEmail(cursor.next(), sub,  mess);
				m.addAttribute("message", "Uspesno poslat newsLetter");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return "unos/NewNewsletter";
	}
	
	@PostMapping(value="/saveEmail")
	public String saveEmailForNewsletter(Model m, String email) {
		NewsletterUser user = new NewsletterUser(email, new Date());
		
		newsletterRepository.save(user);
		m.addAttribute("message", "Uspesna prijava na newsletter!");
		
		return indexController.index(m);
	}

}
