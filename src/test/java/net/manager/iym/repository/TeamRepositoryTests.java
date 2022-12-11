package net.manager.iym.repository;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Team;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class TeamRepositoryTests {
    @Autowired
    private TeamRepository teamRepository;

    @Test
    public void testRegisterTeam(){
        Team team = Team.builder()
                .teamAge("30대").teamName("ict05").teamType("남성").teamLocal("서울").teamLevel("3")
                .teamInfo("안녕하세요 같이 뜁시다.")
                .build();
            teamRepository.save(team);
    }
}
