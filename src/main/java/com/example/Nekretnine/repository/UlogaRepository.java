package com.example.Nekretnine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Nekretnine.model.Uloga;

public interface UlogaRepository extends MongoRepository<Uloga, String> {
	
	Uloga findByUloga(String uloga);
}
