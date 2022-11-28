package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
