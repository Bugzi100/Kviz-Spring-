package com.example.demo.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.services.KorisnikService;
import com.example.demo.services.KvizService;
import com.example.demo.services.PrijateljiService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;
import model.Rezultati;

@Controller
public class PrijateljiController {

	@Autowired
	KorisnikService ks;
	
	@Autowired
	PrijateljiService ps;
	
	@Autowired
	KvizService qs;
	
	@PostMapping("/dodajPrijatelja")
	public String dodajPrijatelja(@RequestParam("userP") String userP, HttpSession session) {
		
		String username = (String) session.getAttribute("username");
		Korisnik korisnik = ks.getKorisnici(username);
		Korisnik prijatelj = ks.getKorisnici(userP);
		
		if (korisnik != null && prijatelj != null) {
			ps.dodajPrijatelja(korisnik, prijatelj);
		}
		
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/prijatelj/{id_prijatelj}/istorijaKviza")
	public String getIstorijaKvizaPrijatelja(Model model, Principal principal, @RequestParam(name = "prijateljId") int prijateljId) {
		
		String username = principal.getName();
		Korisnik korisnik = ks.getKorisnici(username);
		
		Korisnik prijatelj = ks.getKorisnik(prijateljId);
		
		List<Rezultati> rezultatiPrijatelja = ps.getRezultatiPrijatelja(korisnik, prijatelj);
		
		model.addAttribute("rezultatiPrijatelja", rezultatiPrijatelja);
		return "istorijaRezultataPrijatelja";
		
	}
	
}
