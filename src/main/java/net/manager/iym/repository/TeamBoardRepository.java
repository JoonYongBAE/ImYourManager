package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.TeamBoard;
import net.manager.iym.repository.search.TeamBoardSearch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long>, TeamBoardSearch {

    @EntityGraph(attributePaths = {"imageSet"})
    @Query("select tb from TeamBoard tb where tb.teamBoardNum =:teamBoardNum")
    TeamBoard findTeamBoardByTeamBoardNum(Long teamBoardNum);//보드 넘버로 보드에 담긴 값 모두 불러옴
}
