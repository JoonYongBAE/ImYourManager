package net.manager.iym.service;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.MemberListDTO;
import net.manager.iym.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
public class TeamServiceTests {
    @Autowired
    private TeamService teamService;
    @Autowired
    private TeamRepository teamRepository;
    @Test
    public void testjoinTeam(){

    }
    @Test
    public void testTeamList(){
       List<MemberListDTO> memberList = teamService.teamMemberlist(1l);
       log.info("팀에 들어갔을 때 그 팀의 팀원리스트 : "+memberList);
    }
}
