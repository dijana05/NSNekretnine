package com.example.Nekretnine.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.Nekretnine.model.NewsletterUser;

@Repository
public interface NewsletterRepository  extends MongoRepository<NewsletterUser, String>{
	
	List<NewsletterUser> findDistinctByEmail();
}
