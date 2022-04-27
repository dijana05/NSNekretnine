package com.example.Nekretnine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Nekretnine.model.Oglas;

@Repository
public interface OglasiRepository extends MongoRepository<Oglas,String> {
	
	public List<Oglas> findByStatus(String status);

	@Query(value = "{'nekretnina.nekretninaID': ?0 }")
	public List<Oglas> findbyNekretninaID(String nekretninaID);

	public List<Oglas> findTop5ByOrderByCenaDesc();

}
