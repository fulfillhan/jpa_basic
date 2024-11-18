package hello.jpaBasic.practiceJpql;

import hello.jpaBasic.practice01.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/*프록시에 대해서*/
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //객체를 생성한 상태(비영속)
            Member member = new Member();
            member.setName("memberA");

            em.getTransaction().begin();

            //객체를 저장한 상태(영속)
            em.persist(member);

            Member findMember = em.find(Member.class, 101L);  //findMember:영속 상태
            em.detach(findMember); // 준영속 상태 : jpa에서 관리되지 않는다.

            em.clear();  //영속성 컨텍스트 완전히 초기화
            em.close();  // 영속성 컨텍스트 종료

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
