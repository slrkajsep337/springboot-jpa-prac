package com.jpa.prac.springbootjpaprac.repository;

import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
