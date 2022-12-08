package net.manager.iym.repository;

import net.manager.iym.domain.TeamBoard;
import net.manager.iym.repository.search.TeamBoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TeamBoardRepository extends JpaRepository<TeamBoard, Long>, TeamBoardSearch {
    TeamBoard findTeamBoardByTeamBoardNum(Long teamBoardNum);//보드 넘버로 보드에 담긴 값 모두 불러옴
}
