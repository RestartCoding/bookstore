package com.bxia.bookstore.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

    private Integer id;

    private String bookName;

    private String author;

    private Float price;

    private Integer inventory;
}
