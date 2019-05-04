package com.bxia.bookstore.service;

import com.bxia.bookstore.domain.Book;

import java.util.List;

public interface BookService {

    /**
     * add a book
     * @param book book
     * @return count
     */
    long addBook(Book book);

    /**
     * 获取全部书籍信息
     * @return List<Book>
     */
    List<Book> getBooksInfo();
}
