package hello.jpaBasic.domain;

import jakarta.persistence.*;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String city;
    private String street;
    private String zipcode;
    @OneToOne(mappedBy ="delivery", fetch = FetchType.LAZY  )
    private Order order;
}
