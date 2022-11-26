package com.jpa.prac.springbootjpaprac.service;


import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateRequest;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewCreateResponse;
import com.jpa.prac.springbootjpaprac.domain.dto.ReviewReadResponse;
import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import com.jpa.prac.springbootjpaprac.repository.HospitalRepository;
import com.jpa.prac.springbootjpaprac.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private final ReviewRepository rr;
    private final HospitalRepository hr;

    public ReviewService(ReviewRepository rr, HospitalRepository hr) {
        this.rr = rr;
        this.hr = hr;
    }

    public ReviewCreateResponse createReview(ReviewCreateRequest requestDto) {
        //hospital_id 로 hospital객체를 먼저 찾아옴 -> optional로 받음 : review에 hospital객체 넣기 위해서
        Optional<Hospital> optHospital = hr.findById(requestDto.getHospitalId());
        //review 엔티티 만들기
        Review review = Review.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .userName(requestDto.getUserName())
                .hospital(optHospital.get())
                .build();
        //.save(): server에서 db로 저장요청 -> 즉 여기에서 요청받은 data를 서버가 db로 요청해서 저장을해준다 .
        Review savedReview = rr.save(review);
        return ReviewCreateResponse.builder()
                .userName(savedReview.getUserName())
                .title(savedReview.getTitle())
                .content(savedReview.getContent())
                .message("리뷰 등록이 성공했습니다")
                .build();
    }

    public Review getReview(Long id) {
        Review review = rr.findById(id)
                .orElseThrow(() -> new RuntimeException("해당 id가 없습니다."));
        return review;
    }


    public List<ReviewReadResponse> findAllByHospitalId(Long hospitalId) {
        Hospital hospital = hr.findById(hospitalId)
                .orElseThrow(()-> new IllegalArgumentException("해당 id가 없습니다"));
        List<ReviewReadResponse> reviews = rr.findByHospital(hospital)
                .stream().map(review -> ReviewReadResponse.builder()
                        .title(review.getTitle())
                        .content(review.getContent())
                        .userName(review.getUserName())
                        .hospitalName(review.getHospital().getHospitalName())
                        .build()
                ).collect(Collectors.toList());
        return reviews;
    }
}
