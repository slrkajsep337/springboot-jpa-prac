package com.jpa.prac.springbootjpaprac.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private String userName;


    //양방향 매핑, 병원과 매핑해주기
    @ManyToOne  //review 입장에서
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

}
