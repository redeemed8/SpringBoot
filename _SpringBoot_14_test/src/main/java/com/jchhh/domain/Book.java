package com.jchhh.domain;

import lombok.Data;

@Data
public class Book {

    private Integer id;
    private String name;
    private String type;
    private String description;

    public Book(Integer id, String name, String type, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
