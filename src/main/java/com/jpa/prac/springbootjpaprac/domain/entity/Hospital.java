package com.jpa.prac.springbootjpaprac.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Hospital {

    @Id
    private Long id;
    private String hospitalName;
    private String roadNameAddress;

    //양방향매핑 병원:one 리뷰:many  //lazy: 지연로딩 -> 권장
    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
    private List<Review> reviews;

}
