package com.example.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.apirest.model.Vote;

public interface VoteRepository extends JpaRepository<Vote, Long> {

    @Query(value =  "SELECT genre.name, " +
                    "COUNT(genre_id) FROM Vote " +
                    "GROUP BY genre.name")
    List<Object[]> getEntries();

    Vote findByEmail(String email);
}
