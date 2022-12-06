package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.service.JoinBoardService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller //빈을 만들어주고 컨트롤러라고 알려준다.
@RequestMapping("/main/joinboard")
@Log4j2
@RequiredArgsConstructor
public class JoinBoardController {//

    private final JoinBoardService joinBoardService;

    @GetMapping("/list")
    public void joinBoardList(){

    }

    @GetMapping("/register")
    public void joinBoardRegisterGet(){

    }

    @PostMapping("/register")
    public String joinBoardRegisterPost(@Valid JoinBoardDTO joinBoardDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("-----(조인보드게시글등록post시작)joinBoardRegisterPost----");

        if (bindingResult.hasErrors()){
            log.info("결과값이 안넘어옴");//결과값이 바인딩안되면 실행됌
        }
        log.info(joinBoardDTO);
        joinBoardService.register(joinBoardDTO);
        return "redirect:/";
    }
}