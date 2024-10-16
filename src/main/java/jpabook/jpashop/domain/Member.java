package jpabook.jpashop.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id  //필수 식별자!!
    @GeneratedValue//디비가 만들어주는 값을 쓰는 조건 ->기본값은 AUTO이다
    @Column(name = "MEMBER_ID")
    private long id;
    @Column(name = "USERNAME")
    private String userName;

    //단방향 연관관계- 객체의 참조와 외래키를 연관을 맺는다
    //외래키가 있는 곳을 기준으로 해라.
    @ManyToOne  //Team과 MEMBER가 어떤 연관관계인지, 팀 기준으로 여러 회원이 있을 수 있다.
    @JoinColumn(name = "TEAM_ID")  //테이블의 TEAM_ID 컬럼과 매핑시킨다.
    private Team team; // 객체의 참조

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void change(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
