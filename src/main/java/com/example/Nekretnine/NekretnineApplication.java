package com.example.Nekretnine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.Nekretnine.controllers.NekretnineController;
@SpringBootApplication()
@EnableAutoConfiguration
@ComponentScan( "com.example.Nekretnine")
@ComponentScan(basePackageClasses = NekretnineController.class)
public class NekretnineApplication {

	public static void main(String[] args) {
		SpringApplication.run(NekretnineApplication.class, args);
	}

}
