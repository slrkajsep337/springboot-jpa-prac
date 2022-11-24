package com.jpa.prac.springbootjpaprac.controller;


import com.jpa.prac.springbootjpaprac.domain.dto.BookResponse;
import com.jpa.prac.springbootjpaprac.service.BookService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/v1/books")
public class BookController {

    private final BookService bs;

    public BookController(BookService bs) {
        this.bs = bs;
    }


    @GetMapping("")
    public ResponseEntity<List<BookResponse>> showList(Pageable pageable) {
        return ResponseEntity.ok().body(bs.findBooks(pageable));
    }

}
