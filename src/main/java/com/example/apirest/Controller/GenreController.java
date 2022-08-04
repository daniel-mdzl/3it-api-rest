package com.example.apirest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.apirest.model.Genre;
import com.example.apirest.repository.GenreRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class GenreController {
    
    @Autowired
    private GenreRepository repository;

    @GetMapping("/genres")
	public List<Genre> findAll() {
		return repository.findAll();
	}
}
