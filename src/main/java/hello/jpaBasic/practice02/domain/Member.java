package hello.jpaBasic.practice02.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Embedded  // 값 타입을 사용하는 곳에 표시
    private Period period;
    @Embedded //값타입
   private Address address;

    //값 타입 컬렉션
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD")
    @JoinColumn(name = "MEMBER_ID")//어떤 컬럼과 조인해야 하는지
    @Column(name = "FOOD_NAME")//컬럼명을 바꿀 수 있다.
    private Set<String> favoriteFood = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =@JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<String> getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(Set<String> favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
