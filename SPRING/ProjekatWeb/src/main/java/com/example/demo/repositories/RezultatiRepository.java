package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Korisnik;
import model.Rezultati;

public interface RezultatiRepository extends JpaRepository<Rezultati, Integer>{

	List<Rezultati> findByKorisnik(Korisnik korisnik);
	
}
