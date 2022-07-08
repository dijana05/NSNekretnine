package com.example.Nekretnine.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Nekretnine.model.ConfirmationToken;

public interface ConfirmationTokenRepository extends MongoRepository<ConfirmationToken, Long> {
	
	Optional<ConfirmationToken> findByToken(String token);
	
	
}
