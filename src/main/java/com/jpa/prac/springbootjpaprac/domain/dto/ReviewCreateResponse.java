package com.jpa.prac.springbootjpaprac.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewCreateResponse {//보내줄(보여줄)데이터

    private String title;
    private String content;
    private String userName;
    private String message; //요청이 성공했는지 보여주는 message

}


