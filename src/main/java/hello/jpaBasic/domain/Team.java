package hello.jpaBasic.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends BaseEntity{
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    // 객체의 양방향관계는 사실 양방향 관계가 아니라 서로 다른 단방향 관계 2개다.
    //테이블에서는 외래키 하나로 두 테이블의 양방향 관계를 관리한다.(양쪽으로 조인할 수 있다.)

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public void addMember(Member member) {
       //member.setTeam(this);
       members.add(member);

    }
}
