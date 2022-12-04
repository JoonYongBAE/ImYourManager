package net.manager.iym.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //빈을 만들어주고 컨트롤러라고 알려준다.
@RequestMapping("/main/joinboard")
public class JoinBoardController {//


    @GetMapping("/list")
    public void joinBoardList(){

    }

}
