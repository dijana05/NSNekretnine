package com.example.Nekretnine.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Nekretnine.model.ConfirmationToken;
import com.example.Nekretnine.model.Korisnik;
import com.example.Nekretnine.repository.KorisnikRepository;

@Service
public class KorisnikService implements UserDetailsService{
	
	private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
	@Autowired
	private KorisnikRepository korisnikRepository;
	@Autowired
	private ConfirmationTokenService confirmationTokenService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {
        return korisnikRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND_MSG, email)));
    }
   
    
    public String signUpUser(Korisnik korisnik) {
    	
    	bCryptPasswordEncoder = new BCryptPasswordEncoder();
    	String encodedPassword = bCryptPasswordEncoder.encode(korisnik.getPassword());
    	korisnik.setSifra(encodedPassword);
    	korisnikRepository.save(korisnik);
    	
    	// TOKEN
    	String token = UUID.randomUUID().toString();

        ConfirmationToken confirmationToken = new ConfirmationToken(
                 token,
                 LocalDateTime.now(),
                 LocalDateTime.now().plusMinutes(15),
                 korisnik
         );

         confirmationTokenService.saveConfirmationToken(
                 confirmationToken);
    	
    	return token;
    	
    	
    }
    
    
    public void enableAppUser(String email) {
	 	Korisnik k = korisnikRepository.findByEmail(email).get();
	 	k.setEnabled(true);
        korisnikRepository.save(k);
}

}
