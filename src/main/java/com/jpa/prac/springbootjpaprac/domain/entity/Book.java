package com.jpa.prac.springbootjpaprac.domain.entity;

import com.jpa.prac.springbootjpaprac.domain.dto.BookResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
//    @Id
//    private Long id;
//    private String name;
//
//    @Column(name = "author_id")
//    private Long authorId;
//
//    //Book을 BookResponse 타입으로 바꾸어주기
//    public static BookResponse of(Book book, String authorName) {
//        return BookResponse.builder()
//                .bookId(book.getId())
//                .bookName(book.getName())
//                .authorName(authorName)
//                .build();
//    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //    private Long authorId;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public static BookResponse of(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .name(book.getName())
                .authorName(book.getAuthor().getName())
                .publisherName(book.getPublisher().getName())
                .build();
    }

}

