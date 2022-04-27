package com.example.Nekretnine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Nekretnine.model.Agencija;

public interface AgencijaRepository extends MongoRepository<Agencija, String> {

}
