package hello.jpaBasic.practice02;


import hello.jpaBasic.practice02.domain.Address;
import hello.jpaBasic.practice02.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
/*임베디드 타입과 값 타입에 대해서*/
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address address = new Address("city","street","zipcode");

            Member member = new Member();
            member.setUsername("hello");
            member.setAddress(address);
            em.persist(member);

            // address를 변경한다면? - 새로운 객체 생성
            Address newAddress = new Address("newCity", address.getStreet(), address.getZipCode());
            member.setAddress(newAddress);


            //영속성 정리
            em.flush();
            em.clear();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
