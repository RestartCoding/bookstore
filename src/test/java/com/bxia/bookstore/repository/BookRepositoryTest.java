package com.bxia.bookstore.repository;

import com.bxia.bookstore.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BookRepositoryTest {

    @Resource
    private BookRepository bookRepository;

    @Test
    public void testSave(){
        Book result = bookRepository.save(Book.builder().bookName("Thinking in java").build());
        assertNotNull(result);
    }
}