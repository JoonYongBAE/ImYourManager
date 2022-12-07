package net.manager.iym.repository;

import net.manager.iym.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    boolean existsByTeamName(String teamName);    //같은 이름을 가진 팀이 있다면 true, 없다면 false

    Team findByteamNum();


    Team findByMemberId(String id);
}
