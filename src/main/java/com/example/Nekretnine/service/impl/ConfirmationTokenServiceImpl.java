package com.example.Nekretnine.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Nekretnine.model.ConfirmationToken;
import com.example.Nekretnine.repository.ConfirmationTokenRepository;
import com.example.Nekretnine.service.ConfirmationTokenService;

@Service
public class ConfirmationTokenServiceImpl implements ConfirmationTokenService {
	
	@Autowired
	private ConfirmationTokenRepository confirmationTokenRepository;
	
	public void saveConfirmationToken(ConfirmationToken token) {
		confirmationTokenRepository.save(token);
	}
	
	public Optional<ConfirmationToken> getToken(String token) {
	        return confirmationTokenRepository.findByToken(token);
	}
	
	public void setConfirmedAt(String token) {
		ConfirmationToken c = confirmationTokenRepository.findByToken(token).get();
		c.setConfirmedAt(LocalDateTime.now());
		confirmationTokenRepository.save(c);
	}
}
