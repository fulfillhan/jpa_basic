package hello.jpaBasic.practice01;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import hello.jpaBasic.practice01.domain.Member;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member = new Member();
            member.setName("member1");
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
