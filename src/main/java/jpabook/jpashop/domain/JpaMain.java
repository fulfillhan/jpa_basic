package jpabook.jpashop.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            //팀저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            //회원 저장
            Member member = new Member();
            member.setUserName("memberA");

            //역방향 연관관계 설정
            team.getMembers().add(member);
            //연관관계의 주인에 값 설정
            member.setTeam(team);

            em.persist(member);

            team.addMember(member);

            em.flush();
            em.clear();

            //조회
            Member findMember = em.find(Member.class, member.getId());
            //참조를 사용해서 연관관계 조회
            //Team findTeam = findMember.getTeam();
            Team findTeam = em.find(Team.class, team.getId());
            int memberSize = findTeam.getMembers().size();

            List<Member> members = findMember.getTeam().getMembers();

            for (Member resultMember : members){
                System.out.println("resultMember = " + resultMember);
            }

            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
