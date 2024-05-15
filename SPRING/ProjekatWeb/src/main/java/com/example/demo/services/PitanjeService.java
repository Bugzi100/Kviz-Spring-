package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.PitanjeRepository;

import model.Pitanje;

@Service
public class PitanjeService {

	@Autowired
	private PitanjeRepository pr;
	
	public Pitanje getpitanje(int pitanjeId) {
		return pr.findById(pitanjeId).orElse(null);
	}
	
	public List<Pitanje> getPitanjaZaKviz(int kvizId) {
		return pr.getPitanjesForKviz(kvizId);
	}
	
}
