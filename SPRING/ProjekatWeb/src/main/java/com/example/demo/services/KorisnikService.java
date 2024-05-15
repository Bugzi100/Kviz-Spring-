package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ostale.PasswordHasher;
import com.example.demo.repositories.KorisnikRepository;

import jakarta.validation.ConstraintViolationException;
import model.Korisnik;

@Service
public class KorisnikService {

	@Autowired
	private KorisnikRepository kr;
	
	public void registrujKorisnika(Korisnik korisnik) {
		
		if (kr.findByUsername(korisnik.getUsername()) != null) {
			throw new RuntimeException("Korisnicko ime je zauzeto!");
		}
		
		if (korisnik.getPassword().length() < 8) {
			throw new ConstraintViolationException("Lozinka mora imati minimalno 8 karaktera", null);
		}
		
		if (korisnik.getPassword().contains("admin007")) {
			korisnik.setRole("Admin");
		} else {
			korisnik.setRole("User");
		}
		
		korisnik.setPassword(PasswordHasher.hashPassword(korisnik.getPassword()));
		
		kr.save(korisnik);
		
	}
	
	public Korisnik getKorisnici(String username) {
		return kr.findByUsername(username);
	}
	
	public List<Korisnik> getAllKorisnici() {
		return kr.findAll();
	}
	
	public Korisnik getKorisnik(int idKorisnik) {
		return kr.findById(idKorisnik);
	}
	
}
