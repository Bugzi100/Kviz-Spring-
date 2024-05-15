package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Kviz;

public interface KvizRepository extends JpaRepository<Kviz, Integer>{

	List<Kviz> findTop5ByOrderByOmiljeniDesc();
	
	List<Kviz> findAll();
	
}
