package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Korisnik;
import model.Prijatelji;
import model.Rezultati;

public interface PrijateljiRepository extends JpaRepository<Prijatelji, Integer>{
	
	@Query("SELECT r FROM Rezultati r JOIN r.korisnik k WHERE k =: korisnik1 OR k =: korisnik2")
	List<Rezultati> getRezultatiPrijatelja(@Param("korisnik1") Korisnik korisnik1, 
										  @Param("korisnik2") Korisnik korisnik2);
	
	boolean existsByKorisnik1AndKorisnik2(Korisnik korisnik1, Korisnik korisnik2);
	
	List<Prijatelji> findByKorisnik1OrKorisnik2(Korisnik korisnik1, Korisnik korisnik2);
}
