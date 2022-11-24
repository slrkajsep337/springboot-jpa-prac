package com.jpa.prac.springbootjpaprac.domain.dto;

import com.jpa.prac.springbootjpaprac.domain.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateRequest {//요청받을 데이터
    //review id는 auto increment로 선언되어서 우리가 작성해줄 필요가 없음
    private Long hospitalId;
    private String title;
    private String content;
    private String userName;


}


