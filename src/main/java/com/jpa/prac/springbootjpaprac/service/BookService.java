package com.jpa.prac.springbootjpaprac.service;

import com.jpa.prac.springbootjpaprac.domain.dto.BookResponse;
import com.jpa.prac.springbootjpaprac.domain.entity.Book;
import com.jpa.prac.springbootjpaprac.repository.AuthorRepository;
import com.jpa.prac.springbootjpaprac.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository br;
    private final AuthorRepository ar;

    public BookService(BookRepository br, AuthorRepository ar) {
        this.br = br;
        this.ar = ar;
    }

//    public List<BookResponse> findBooks(Pageable pageable) {
//        Page<Book> books = br.findAll(pageable);
//        List<BookResponse> bookResponses = books.stream()
//                .map(book -> { //
//                    Optional<Author> optAuthor = ar.findById(book.getAuthorId());
//                    String name = optAuthor.get().getName();
//                    BookResponse bookResponse = Book.of(book, name);
//                    return bookResponse;
//                }).collect(Collectors.toList());
//        return bookResponses;
//    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = br.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book -> Book.of(book)).collect(Collectors.toList());
        return bookResponses;
    }

}
