package com.jpa.prac.springbootjpaprac.repository;

import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHospital(Hospital hospital);
}
