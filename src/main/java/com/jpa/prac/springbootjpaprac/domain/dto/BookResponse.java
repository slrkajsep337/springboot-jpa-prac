package com.jpa.prac.springbootjpaprac.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookResponse {
    private Long id;
    private String name;
    private String authorName;
    private String publisherName;

    public BookResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }


}



