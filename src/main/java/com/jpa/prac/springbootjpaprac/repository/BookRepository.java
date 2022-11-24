package com.jpa.prac.springbootjpaprac.repository;

import com.jpa.prac.springbootjpaprac.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}


