package hello.jpaBasic.domain;

import jakarta.persistence.*;

/*1:1 연관관계*/
@Entity
public class Locker {
    @Id @GeneratedValue
    //@Column(name = "LOCKER_ID")
    private Long id;

    private String name;

    //양방향으로 하고싶다면? -  대상 테이블
    @OneToOne(mappedBy = "locker")
    private Member member;
}
