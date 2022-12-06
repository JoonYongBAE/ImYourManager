package net.manager.iym.repository;

import net.manager.iym.domain.JoinBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinBoardRepository extends JpaRepository<JoinBoard, Long> {
    JoinBoard findJoinBoardByJoinBoardNum(Long joinBoardNum);//보드 넘버로 보드에 담긴 값 모두 불러옴
}