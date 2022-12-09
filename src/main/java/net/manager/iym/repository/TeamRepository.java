package net.manager.iym.repository;

import net.manager.iym.domain.Team;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.repository.search.TeamSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long>, TeamSearch {
    Team findTeamByTeamNum(Long teamNum);
}
