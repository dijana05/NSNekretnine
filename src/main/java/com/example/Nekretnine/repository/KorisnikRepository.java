package com.example.Nekretnine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Nekretnine.model.Agent;
import com.example.Nekretnine.model.Korisnik;

@Repository
public interface KorisnikRepository extends MongoRepository<Korisnik, String> {
	
	public Optional<Korisnik> findByEmail(String email);

	public List<Agent> findByAgencijaNotNull();

	public Optional<Korisnik> findByEmailAndSifra(String username, String password);
	
	

}
