package com.example.Nekretnine.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.Nekretnine.service.impl.KorisnikService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private KorisnikService korisnikService;
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
				.antMatchers("/**").permitAll()
				.antMatchers("/assets/**", "/images/**").permitAll()
				.antMatchers("/*.css").permitAll()
				.antMatchers("/*.js").permitAll()
				.antMatchers("/","/index","/login", "/korisnik/loginPage", "/korisnik/registracijaPage", "/korisnik/registracija*" ).permitAll()
			.anyRequest()
			.authenticated()
			.and().formLogin()
			.loginProcessingUrl("/userAuth")
				.loginPage("/korisnik/loginPage")
				.defaultSuccessUrl("/index.jsp", true)
				.failureUrl("/login.jsp?error=true")
			.and()
			.logout().permitAll();
	}
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // auth.authenticationProvider(daoAuthenticationProvider());
		auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder().encode("user")).roles("USER").and()
									.withUser("admin").password(bCryptPasswordEncoder().encode("admin")).roles("ADMIN");
	}
	
	
	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	}
	
	@Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        provider.setUserDetailsService(korisnikService);
        return provider;
    }

}
