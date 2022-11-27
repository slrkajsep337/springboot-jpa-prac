package com.jpa.prac.springbootjpaprac.service;

import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import com.jpa.prac.springbootjpaprac.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalService {

    private final HospitalRepository hr;

    public Hospital findById(Long id) {
        Hospital hospital = hr.findById(id)
                .orElseThrow(()->new IllegalArgumentException("id가 없습니다."));
                //id가 없을 경우(null) 예외처리
        return hospital;
    }
}


