package com.example.Nekretnine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Nekretnine.service.NewsletterService;

@Service
public class NewsletterServiceImpl implements NewsletterService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public NewsletterServiceImpl(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage mess = new SimpleMailMessage();
		mess.setTo(to);
		mess.setText(message);
		mess.setFrom("dixy.nbns.96@gmail.com");
		mess.setSubject(subject);
		try {
			this.mailSender.send(mess);
		}catch(MailException e) {
			e.printStackTrace();
		}
	}

}
