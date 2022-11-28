package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
