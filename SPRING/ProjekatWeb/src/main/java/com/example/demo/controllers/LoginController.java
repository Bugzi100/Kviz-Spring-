package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.ostale.PasswordHasher;
import com.example.demo.services.KorisnikService;

import jakarta.servlet.http.HttpSession;
import model.Korisnik;

@Controller
public class LoginController {

	@Autowired
	KorisnikService ks;
	
	@GetMapping("/login")
	public String prikaziLoginFormu() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginHanlde(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
		Korisnik korisnik = ks.getKorisnici(username);
		
		if (korisnik != null && korisnik.getPassword().equals(PasswordHasher.hashPassword(password))) {
			session.setAttribute("username", username);
			return "redirect:/dashboard.jsp";
		} else {
			model.addAttribute("error", "Pogresno korisnicko ime ili lozinka!");
			return "login";
		}
	}
	
}
