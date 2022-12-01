package net.manager.iym.repository;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.JoinBoard;
import net.manager.iym.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class JoinBoardRepositoryTests {
    @Autowired
    private JoinBoardRepository joinBoardRepository;

    @Test
    public void testInsert(){
        IntStream.rangeClosed(4,5).forEach(i->{
            JoinBoard joinBoard = JoinBoard.builder()
                    .joinTitle("제목"+i)
                    .joinContent("내용"+i)
                    .joinType("모집")
                    .joinVisitCount(0l)
                    .build(); //joinboard게시판에 게시글 3개 만듦
            JoinBoard joinBoardResult = joinBoardRepository.save(joinBoard);
            log.info("JoinBoardNum : " + joinBoardResult.getJoinBoardNum());
        });
    }
}
