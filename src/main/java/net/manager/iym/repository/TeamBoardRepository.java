package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.TeamBoard;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long> {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select tb from TeamBoard tb where tb.teamBoardNum =:teamBoardNum")
    Optional<TeamBoard> findByIdWithImages(Long teamBoardNum);
}
