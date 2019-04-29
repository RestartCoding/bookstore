package com.bxia.bookstore.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Builder
@Document(indexName = "book", type = "_doc")
public class Book {

    @Id
    private Integer id;

    private String bookName;

    private String author;

    private Float price;

    private Integer inventory;
}
