package com.example.Nekretnine.service;

public interface EmailSender {
	 
	void sendEmail(String to, String subject, String message);
	
}
