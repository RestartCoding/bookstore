package com.bxia.bookstore.controller;

import com.bxia.bookstore.domain.Book;
import com.bxia.bookstore.service.BookService;
import com.bxia.bookstore.web.CommonResponse;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Resource
    private BookService bookService;

    @PostMapping
    public CommonResponse addBook(@RequestBody Book book){
        long id = bookService.addBook(book);
        return CommonResponse.ok(id);
    }

    @GetMapping
    public List<Book> getBooksInfo(){
        return bookService.getBooksInfo();
    }
}
