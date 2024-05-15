package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.PrijateljiRepository;

import model.Korisnik;
import model.Prijatelji;
import model.Rezultati;

@Service
public class PrijateljiService {

	@Autowired
	PrijateljiRepository pr;
	
	public void dodajPrijatelja(Korisnik user, Korisnik prijatelj) {
		
		if (!jesuPrijatelji(user, prijatelj)) {
			Prijatelji prijatelji = new Prijatelji(user, prijatelj);
			pr.save(prijatelji);
		}
		
	}

	private boolean jesuPrijatelji(Korisnik user, Korisnik prijatelj) {
		return pr.existsByKorisnik1AndKorisnik2(user, prijatelj);
	}

	public List<Korisnik> getPrijatelj(Korisnik korisnik) {
		List<Prijatelji> prijateljstva = pr.findByKorisnik1OrKorisnik2(korisnik, korisnik);
		
		List<Korisnik> prijatelji = new ArrayList<>();
		for (Prijatelji prijateljstvo : prijateljstva) {
			
			if (!prijateljstvo.getKorisnik1().equals(korisnik)) {
				prijatelji.add(prijateljstvo.getKorisnik1());
			}
			
			if (!prijateljstvo.getKorisnik2().equals(korisnik)) {
				prijatelji.add(prijateljstvo.getKorisnik2());
			}
			
		}
		
		return prijatelji;
	}

	public List<Rezultati> getRezultatiPrijatelja(Korisnik korisnik1, Korisnik korisnik2) {
		return pr.getRezultatiPrijatelja(korisnik1, korisnik2);
	}
	
}
