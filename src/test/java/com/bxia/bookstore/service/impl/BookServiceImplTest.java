package com.bxia.bookstore.service.impl;

import com.bxia.bookstore.domain.Book;
import com.bxia.bookstore.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookServiceImplTest {

    @Resource
    private BookService bookService;

    @Test
    public void addBook() {
        Book book = Book.builder()
                .bookName("Hello")
                .author("Jack Xia")
                .price(88F)
                .inventory(0)
                .build();
        long id = bookService.addBook(book);
        assertTrue(id > 0);
    }
}