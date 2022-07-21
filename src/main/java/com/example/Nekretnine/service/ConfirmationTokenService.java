package com.example.Nekretnine.service;

import java.util.Optional;

import com.example.Nekretnine.model.ConfirmationToken;

public interface ConfirmationTokenService {
	
	public void saveConfirmationToken(ConfirmationToken token);
	
	public Optional<ConfirmationToken> getToken(String token);
	
	public void setConfirmedAt(String token);
}
