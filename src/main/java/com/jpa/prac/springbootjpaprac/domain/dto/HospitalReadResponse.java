package com.jpa.prac.springbootjpaprac.domain.dto;


import com.jpa.prac.springbootjpaprac.domain.entity.Hospital;
import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class HospitalReadResponse {
    private Long id;
    private String hospitalName;
    private String roadNameAddress;
    private List<ReviewReadResponse> reviews;

    public static HospitalReadResponse toDto(Hospital hospital) {
        return HospitalReadResponse.builder()
                .id(hospital.getId())
                .hospitalName(hospital.getHospitalName())
                .roadNameAddress(hospital.getRoadNameAddress())
                .reviews(hospital.getReviews().stream()
                        .map(review -> ReviewReadResponse.toDto(review)).collect(Collectors.toList()))
                .build();
    }
}


