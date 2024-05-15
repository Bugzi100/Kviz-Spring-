package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.services.KorisnikService;
import com.example.demo.services.RezultatiService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;
import model.Rezultati;

@Controller
public class RezultatiController {

	@Autowired
	RezultatiService rs;
	
	@Autowired
	KorisnikService ks;
	
	@GetMapping("/istorijaRezultata")
	public String istorijaRezultata(Model model, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		Korisnik korisnik = ks.getKorisnici(username);
		
		List<Rezultati> rezultati = rs.getRezultati(korisnik);
		model.addAttribute("rezultati", rezultati);
		
		return "istorijaRezultata";
	}
	
}
