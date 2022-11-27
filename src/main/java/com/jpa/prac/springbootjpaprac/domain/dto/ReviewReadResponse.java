성package com.jpa.prac.springbootjpaprac.domain.dto;


import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewReadResponse {

    private Long id;
    private String title;
    private String content;
    private String userName;
    private String hospitalName;

    public static ReviewReadResponse toDto(Review review) {
        ReviewReadResponse response = ReviewReadResponse.builder()
                .id(review.getId())
                .title(review.getTitle())
                .content(review.getContent())
                .userName(review.getUserName())
                .hospitalName(review.getHospital().getHospitalName())
                .build();
        return response;
    }

}
