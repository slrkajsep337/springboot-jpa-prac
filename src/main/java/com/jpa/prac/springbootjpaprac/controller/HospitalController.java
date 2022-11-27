package com.jpa.prac.springbootjpaprac.controller;


import com.jpa.prac.springbootjpaprac.domain.dto.HospitalReadResponse;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateRequest;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateResponse;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewReadResponse;
import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import com.jpa.prac.springbootjpaprac.repository.ReviewRepository;
import com.jpa.prac.springbootjpaprac.service.HospitalService;
import com.jpa.prac.springbootjpaprac.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewService rs;
    private final HospitalService hs;

    public HospitalController(ReviewService rs, HospitalService hs) {
        this.rs = rs;
        this.hs = hs;
    }

    //리뷰 1개 등록하는 기능 -> reviewCreateRequest, reviewCreateResponse 사용
    @PostMapping("/{id}/reviews")
    //@RequestBody : 여러 정보를 requestBody에 jason 형식으로 입력한다
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest requestDto){
        log.info("{}",requestDto);
        return ResponseEntity.ok().body(rs.createReview(requestDto));

    }


    //조회 하는 기능들 3가지 -> reviewReadResponse 사용

    //리뷰 1개 조회 기능
    //GET /api/v1/reviews/{id}
    @GetMapping("review/{id}")
    public ResponseEntity<ReviewReadResponse> getOneReview(@PathVariable Long id) {
        Review review = rs.getReview(id);
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalName("병원이름 빈칸")
                .build();
        return ResponseEntity.ok().body(response);

    }

    //해당 병원의 전체 리뷰 조회하기 (병원정보는 X)
    @GetMapping("reviews/{hospitalId}")
    public ResponseEntity<List<ReviewReadResponse>> getReviews(@PathVariable Long hospitalId) {
        return ResponseEntity.ok().body(rs.findAllByHospitalId(hospitalId));
    }


    @GetMapping("/{id}")
    public ResponseEntity<HospitalReadResponse> getHospital(@PathVariable Long id) {
        Hospital hospital = hs.findById(id);
        HospitalReadResponse response = HospitalReadResponse.toDto(hospital);
        return ResponseEntity.ok().body(response);
    }




}
