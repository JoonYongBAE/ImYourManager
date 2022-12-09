package net.manager.iym.service;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.repository.TeamRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
