package com.jpa.prac.springbootjpaprac.controller;


import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateRequest;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateResponse;
import com.jpa.prac.springbootjpaprac.repository.ReviewRepository;
import com.jpa.prac.springbootjpaprac.service.ReviewService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/v1/hospitals")
@Slf4j
public class HospitalController {

    private final ReviewRepository rr;
    private final ReviewService rs;

    public HospitalController(ReviewRepository rr, ReviewService rs) {
        this.rr = rr;
        this.rs = rs;
    }

    @PostMapping("/{id}/reviews")
    public ResponseEntity<ReviewCreateResponse> add(@RequestBody ReviewCreateRequest requestDto){
        log.info("{}",requestDto);
        return ResponseEntity.ok().body(rs.createReview(requestDto));

    }
}
