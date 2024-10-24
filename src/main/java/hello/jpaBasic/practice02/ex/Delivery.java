package hello.jpaBasic.practice02.ex;

import hello.jpaBasic.domain.Order;
import jakarta.persistence.*;

@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @Embedded
    private Address address;
    @OneToOne(mappedBy ="delivery", fetch = FetchType.LAZY  )
    private Order order;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
