package com.bxia.bookstore.service.impl;

import com.bxia.bookstore.domain.Book;
import com.bxia.bookstore.repository.BookRepository;
import com.bxia.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    @Override
    public long addBook(Book book) {
        log.info("add book [{}]", book);
        Book result = bookRepository.save(book);
        return result.getId();
    }

    @Override
    public List<Book> getBooksInfo() {
        Iterable<Book> iterable = bookRepository.findAll();
        List books = new ArrayList<Book>();
        iterable.forEach(books::add);
        return books;
    }
}