package net.manager.iym.repository;

import net.manager.iym.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByTeamName(String teamName);    //같은 이름을 가진 팀이 있다면 true, 없다면 false
    Optional<Team> findById(Long teamNum);

}
