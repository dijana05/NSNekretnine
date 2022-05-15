package com.example.Nekretnine.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Nekretnine.model.Nekretnina;

@Repository
public interface NekretnineRepository extends MongoRepository<Nekretnina, String>{

	Optional<Nekretnina> findByNekretninaID(String nekretnina);
	
	Page<Nekretnina> findAll(Pageable pageable);
	
	Page<Nekretnina> findAllByOrderByPovrsinaAsc(Pageable pageable);
	
	Page<Nekretnina> findAllByOrderByPovrsinaDesc(Pageable pageable);
	
	
}
