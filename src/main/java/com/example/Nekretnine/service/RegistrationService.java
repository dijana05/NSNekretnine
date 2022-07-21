package com.example.Nekretnine.service;

import org.springframework.ui.Model;

import com.example.Nekretnine.model.RegistrationRequest;

public interface RegistrationService {
	
	public String register(Model m,RegistrationRequest request);
}
