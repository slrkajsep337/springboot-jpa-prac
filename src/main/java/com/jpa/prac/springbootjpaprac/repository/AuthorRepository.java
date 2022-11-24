package com.jpa.prac.springbootjpaprac.repository;


import com.jpa.prac.springbootjpaprac.domain.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}


