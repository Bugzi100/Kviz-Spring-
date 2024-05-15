package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.Pitanje;

public interface PitanjeRepository extends JpaRepository<Pitanje, Integer>{
	
	@Query("SELECT p FROM Pitanje p WHERE p.kviz.id = :kvizId")
	List<Pitanje> getPitanjesForKviz(int kvizId);
	
}
