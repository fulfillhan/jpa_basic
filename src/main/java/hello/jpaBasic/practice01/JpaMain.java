package hello.jpaBasic.practice01;

import hello.jpaBasic.practice01.domain.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import hello.jpaBasic.practice01.domain.Member;
/*프록시에 대해서*/
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setName("member1");
            member.setCity("서울시");
            em.persist(member);

            //영속성 정리
            em.flush();
            em.clear();

            Member refMember = em.getReference(Member.class, member.getId()); // 프록시 초기화
            System.out.println("refMember.getName() = " + refMember.getName());
            System.out.println("refMember.getClass() = " + refMember.getClass());


            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
