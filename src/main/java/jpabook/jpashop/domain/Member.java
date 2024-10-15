package jpabook.jpashop.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Member {
    @Id  //필수 식별자!!
    @GeneratedValue//디비가 만들어주는 값을 쓰는 조건 ->기본값은 AUTO이다
    @Column(name = "MEMEBER_ID")
    private long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;

    //setter  고민할 필요가 있다. 막 만들면 아무데서나 할 수 있어서 가급적 생성자에서 사용하기!!
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
