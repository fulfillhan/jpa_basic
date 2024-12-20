package hello.jpaBasic.practice01.domain;

import jakarta.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) // 단일 테이블 전략으로 생성.
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 단일 테이블 전략으로 생성.
@DiscriminatorColumn // String name() default "DTYPE"; 구분하기 위해서 사용
public abstract class Item extends BaseEntity{

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;
    private String name;
    private int price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}
