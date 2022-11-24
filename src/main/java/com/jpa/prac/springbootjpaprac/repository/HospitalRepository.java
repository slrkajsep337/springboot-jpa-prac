package com.jpa.prac.springbootjpaprac.repository;

import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
