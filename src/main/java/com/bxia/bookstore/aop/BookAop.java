package com.bxia.bookstore.aop;

import com.bxia.bookstore.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class BookAop {
    @Before("execution(* com.bxia.bookstore.service.BookService.addBook(..)) && args(book))")
    public void beforeSave(Book book){
        log.info("[{}]", book);
        if (null != book && null == book.getId()){
            book.setId();
        }
    }
}