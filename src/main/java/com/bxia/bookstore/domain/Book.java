package com.bxia.bookstore.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.concurrent.atomic.AtomicLong;

@Data
@Builder
@Document(indexName = "book", type = "_doc")
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Transient
    private static AtomicLong counter = new AtomicLong(1);

    @Id
    private Long id;

    private String bookName;

    private String author;

    private Float price;

    private Integer inventory;

    public void setId(){
        this.id = counter.incrementAndGet();
    }
}
