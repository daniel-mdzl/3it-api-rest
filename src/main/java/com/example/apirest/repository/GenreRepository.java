package com.example.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.apirest.model.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
}
