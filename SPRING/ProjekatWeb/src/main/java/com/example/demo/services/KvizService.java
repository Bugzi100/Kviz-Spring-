package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.KvizRepository;

import model.Kviz;

@Service
public class KvizService {

	@Autowired
	private KvizRepository kr;
	
	public List<Kviz> getAllKvizovi() {
		return kr.findAll();
	}

	public Kviz getKvizById(int kvizId) {
		return kr.findById(kvizId).orElse(null);
	}
	
	public void saveKviz(Kviz kviz) {
		kr.save(kviz);
	}

	public List<Kviz> topKvizovi() {
		return kr.findTop5ByOrderByOmiljeniDesc();
	}
	
}
