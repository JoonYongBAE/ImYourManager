package net.manager.iym.repository;

import net.manager.iym.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, String> {
    @EntityGraph(attributePaths = "gradeSet")
    @Query("select m from Member m where m.id = :id") //:의 뜻??
    Optional<Member> getWithGrade(String id);
    // 로그인시에 멤버와 멤버의 등급을 같이 로딩을 할 수 있도록 기능을 추가한 메소드
    // 직접 로그인할 때는 소셜 서비스를 통해서 회원 가입된 회원들이 같은 패스워드를 가지므로 일반 회원들만 가져오도록
    // social 필드가 false 값인 tuple(row)만 가져온다.

//    @EntityGraph(attributePaths = "id")
//    @Query("select m from Member m where m.id = :id")
    Member findMemberById(String id); //Id로 멤버 정보를 불러와준다.


}
