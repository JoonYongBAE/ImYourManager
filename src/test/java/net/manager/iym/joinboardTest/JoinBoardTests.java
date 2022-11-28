package net.manager.iym.joinboardTest;

import lombok.extern.log4j.Log4j2;
import net.manager.iym.service.JoinBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class JoinBoardTests {

    @Autowired
    private JoinBoardService joinBoardService;



}
