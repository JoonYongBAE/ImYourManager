package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.TeamBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {
}
