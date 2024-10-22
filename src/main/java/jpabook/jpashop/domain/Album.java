package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Album extends Item{
    private Long id;
    private String artist;
}
