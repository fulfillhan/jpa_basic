package hello.jpaBasic.practice02;


import hello.jpaBasic.practice02.domain.Address;
import hello.jpaBasic.practice02.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;

/*임베디드 타입과 값 타입에 대해서*/
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

         Member member = new Member();
         member.setUsername("member1");
         member.setAddress(new Address("city","street","zipcode"));

         //컬렉션
            member.getFavoriteFood().add("치킨");
            member.getFavoriteFood().add("떡볶이");
            member.getFavoriteFood().add("피자");

            member.getAddressHistory().add(new Address("old1","street","zipcode"));
            member.getAddressHistory().add(new Address("old2","street","zipcode"));

            em.persist(member);

            //영속성 정리
            em.flush();
            em.clear();

            Member findMember = em.find(Member.class, member.getId());

            //컬렉션도 지연 로딩이다.
            List<Address> addressHistory = findMember.getAddressHistory();
            for (Address address : addressHistory) {
                System.out.println("address.getCity() = " + address.getCity());
            }

            Address findAddress = findMember.getAddress();
            //불변객체 - 새로 만들어야함
            findMember.setAddress(new Address("newCity",findAddress.getStreet(),findAddress.getZipCode()));

            //컬렉션의 값 변경
            //값 타입은 멤버에 의존관계를 맡긴다.
            findMember.getFavoriteFood().remove("치킨");
            findMember.getFavoriteFood().add("쌀국수");

            //객체 전체를 변경-> Address객체는 equals와 hashCode 재정의 되어 있어야 한다.
          /*  findMember.getAddressHistory().remove(new Address("newCity",findAddress.getStreet(),findAddress.getZipCode());
            findMember.getAddressHistory().add(new Address("newCity",findAddress.getStreet(),findAddress.getZipCode());*/


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
