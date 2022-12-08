package net.manager.iym.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import net.manager.iym.domain.Team;
import net.manager.iym.dto.JoinBoardDTO;
import net.manager.iym.dto.TeamDTO;
import net.manager.iym.dto.paging.PageRequestDTO;
import net.manager.iym.dto.paging.PageResponseDTO;
import net.manager.iym.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/main/team")
@RequiredArgsConstructor
@Log4j2
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/register")
    public void teamRegisterGET(){
        //로그인한 사람의 아이디를 받는다.
        //받은 아이디로 팀넘을 확인하고 있을시 돌려보낸다.
        //teamservice.teamcheck    isempty()

    }
    @PostMapping("/teamjoin")
    public String teamJoin(@Valid TeamDTO teamDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        log.info("----팀가입 컨트롤러 시작----");
        log.info("팀조인디티오의 값 : "+teamDTO);
        teamService.teamJoin(teamDTO);

        return "redirect:/main/team/list";
    }
    @GetMapping("/list")
    public void teamList(PageRequestDTO pageRequestDTO, Model model){
        PageResponseDTO<TeamDTO> responseDTO =
                teamService.list(pageRequestDTO); // 조인보드DTO 리스트를 담음

        log.info("팀 리스폰스DTO값 : " +responseDTO);

        model.addAttribute("responseDTO", responseDTO); //담은 조인보드DTO 리스트를 뷰로 보내줌

    }
    @GetMapping("/read")
    public void teamRead(Long teamNum, PageRequestDTO pageRequestDTO, Model model){
        TeamDTO teamDTO = teamService.readOne(teamNum);
        log.info("teamDTO의 값 확인하기 : "+teamDTO);
        model.addAttribute("teamDTO", teamDTO);
    }
    @PostMapping("/register")
    public String teamRegisterPOST(@Valid TeamDTO teamDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
       log.info("-----팀생성 컨트롤러 시작-----");
        if (bindingResult.hasErrors()){
            log.info("/register에 결과값이 안넘어옴");//결과값이 바인딩안되면 실행됨
            return "redirect:/";
        }
        log.info(teamDTO);
        Long teamNum = teamService.register(teamDTO);
        log.info(teamNum);
        return "redirect:/main/team/list";
    }
}
