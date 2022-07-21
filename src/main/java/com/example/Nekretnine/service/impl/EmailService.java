package com.example.Nekretnine.service.impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.Nekretnine.service.EmailSender;

@Service
public class EmailService implements EmailSender {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public EmailService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	public void sendEmail(String to, String subject, String message) {
		
		try {
			MimeMessage mess = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mess, "utf-8");
			helper.setTo(to);
			helper.setText(message, true);
			helper.setFrom("nsnekretnine22@gmail.com");
			helper.setSubject(subject);
			
			this.mailSender.send(mess);
		}catch(Exception e) {
			e.printStackTrace();
			throw new IllegalStateException("failed to send email");
		}
	}

}
