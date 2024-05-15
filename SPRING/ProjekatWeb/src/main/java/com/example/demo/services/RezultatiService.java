package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.RezultatiRepository;

import model.Korisnik;
import model.Kviz;
import model.Rezultati;

@Service
public class RezultatiService {

	@Autowired
	RezultatiRepository rr;
	
	public List<Rezultati> getRezultati(Korisnik korisnik) {
		return rr.findByKorisnik(korisnik);
	}
	
	public void saveRezultati(Korisnik korisnik, Kviz kviz, int skor) {
		Rezultati rezultati = new Rezultati();
		rezultati.setKorisnik(korisnik);
		rezultati.setKviz(kviz);
		rezultati.setSkor(skor);
		rr.save(rezultati);
	}

}
