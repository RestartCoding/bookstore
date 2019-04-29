package com.bxia.bookstore.repository;

import com.bxia.bookstore.domain.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface BookRepository extends ElasticsearchRepository<Book, Integer> {

}
