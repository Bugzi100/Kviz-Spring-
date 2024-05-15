package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.services.KorisnikService;

import model.Korisnik;

@Controller
public class RegistrationController {

	@Autowired
	private KorisnikService ks;
	
	@GetMapping("registracija")
	public String prikaziFormuZaRegistraciju(Model model) {
		model.addAttribute("korisnik", new Korisnik());
		return "registracija";
	}
	
	@PostMapping("registracija")
	public String registrujKorisnika(@ModelAttribute("korisnik") Korisnik korisnik) {
		ks.registrujKorisnika(korisnik);
		return "login";
	}
	
}
