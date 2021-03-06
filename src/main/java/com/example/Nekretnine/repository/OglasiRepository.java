package com.example.Nekretnine.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.model.Oglas;

@Repository
public interface OglasiRepository extends MongoRepository<Oglas,String> {
	
	public List<Oglas> findByStatus(String status);

	@Query(value = "{'nekretnina.nekretninaID': ?0 }")
	public List<Oglas> findbyNekretninaID(String nekretninaID);

	public List<Oglas> findTop5ByOrderByCenaDesc();
	
	public Page<Oglas> findAll(Pageable pageable);

	@Query(value="{'nekretnina.tip': ?0, 'cena': {$lte : ?2, $gt: ?1}}")
	public Page<Oglas> findByTipCena(String tip, double min, double max, Pageable pageable);
	
	@Query(value="{'nekretnina.tip': ?0, 'cena': {$lte : ?2, $gt: ?1}, 'kreirao.korisnikID': ?3 }")
	public Page<Oglas> findByTipCena(String tip, double min, double max, String id, Pageable pageable);

	public List<Oglas> findByKreirao(Korisnik k);

	public List<Oglas> findByKreirao(Korisnik k, Pageable pageable);

	public Page<Oglas> findByKreiraoKorisnikID(String id, Pageable pageable);
	

}
