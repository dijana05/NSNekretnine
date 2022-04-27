package com.example.Nekretnine;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Nekretnine.controllers.OglasiController;

@Controller
public class IndexController {
	
	@Autowired
	private OglasiController oglasiController;
		
	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
	 	oglasiController.sviOglasiSvi(request, model);
		
		return "index";
	}
}
