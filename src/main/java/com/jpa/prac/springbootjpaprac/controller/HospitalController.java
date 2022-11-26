package com.jpa.prac.springbootjpaprac.controller;


import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateRequest;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateResponse;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewReadResponse;
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

    private final ReviewRepository rr;
    private final ReviewService rs;
    private final HospitalService hs;

    public HospitalController(ReviewRepository rr, ReviewService rs, HospitalService hs) {
        this.rr = rr;
        this.rs = rs;
        this.hs = hs;
    }

    //리뷰 1개 입력받는 기능
    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest requestDto){
        log.info("{}",requestDto);
        return ResponseEntity.ok().body(rs.createReview(requestDto));

    }

    //리뷰 1개 조회 기능
    //GET /api/v1/reviews/{id}
    @GetMapping("/{id}")
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

    //해당 병원의 전체 리뷰 조회하기
    @GetMapping("/{hospitalId}/reviews")
    public ResponseEntity<List<ReviewReadResponse>> getReviews(@PathVariable Long hospitalId) {
        return ResponseEntity.ok().body(rs.findAllByHospitalId(hospitalId));
    }


    //해당 병원의 리뷰 + 병원 정보까지 조회하기
//    @GetMapping("/{id}")
//    public ResponseEntity<ReviewReadResponse> getReviewAndHospital(@PathVariable Long id) {
//        Review review = rs.getReview(id);
//        ReviewReadResponse response = ReviewReadResponse.toDto(review);
//        return ResponseEntity.ok().body(response);
//    }




}
