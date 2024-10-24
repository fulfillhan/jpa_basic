package hello.jpaBasic.domain;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{
    private String author;
    private int isbn;
}
